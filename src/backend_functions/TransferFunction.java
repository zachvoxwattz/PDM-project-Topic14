package backend_functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ui.MenuUI;
import ui.TransferUI;

public class TransferFunction implements ActionListener
{
	private SQLQueryClient sql;
	private User usr;
	private TransferUI trans;
	private int attempt = 0;
	
	public TransferFunction(SQLQueryClient s, User us, TransferUI base)
	{
		this.sql = s;
		this.usr = us;
		this.trans = base;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String reID = trans.getRecipientID();
		String amount = trans.getTransferAmount();
		String text = trans.getComments();
		String location = usr.getLocation();
		String transType = "TS";
		
		if (sql.testConnection())
		{
			if (!sql.checkLock(usr.getCardNo()))
			{	
				if (sql.checkCardBalance(usr.getCardNo(), trans.getTransferAmount()))
				{
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog
						(null, "Confirm transfering to this account?\nSelect NO to review your information", "Notice", dialogButton);
					
					if (dialogResult == 0) 
					{
						if (sql.checkUsage(usr.getCardNo(), amount) || sql.checkLocation(usr.getCardNo(), usr.getLocation()))
						{
							attempt = 0;
							
							while(true)
							{
								if (sql.checkAccIDExist(reID))
								{
									String accountID = JOptionPane.showInputDialog
											(null,"Verification Required! Please enter your AccountID below", "Notice", 
													JOptionPane.INFORMATION_MESSAGE);
									
									if (accountID.equals(sql.getAccountNo(usr.getCardNo())))
									{
										makeTransaction(transType, reID, location, amount, text);
										break;
									}
									
									else
									{
										attempt++;
										JOptionPane.showMessageDialog
										(null,"Incorrect Account Number\nPlease try again\n" + attempt + " attempt(s)", "Error", 
											JOptionPane.WARNING_MESSAGE);
									}
									if (attempt == 3) 
									{
										JOptionPane.showMessageDialog(null,"FAILED AFTER 3 Attempts. This Credit Card has been LOCKED\nContact Bank Support for more information", "WARNING", 
												JOptionPane.WARNING_MESSAGE);
										sql.lockCard(usr.getCardNo());
										break;
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Account Number does not exist", "Error",
												JOptionPane.WARNING_MESSAGE);
									break;
								}
							}
							
						}
						else makeTransaction(transType, reID, location, amount, text);
					}
				}
				
				else JOptionPane.showMessageDialog(null,"Insufficient funds to perform this action!", "Error", 
						JOptionPane.WARNING_MESSAGE);
			}
			
			else JOptionPane.showMessageDialog(null,"THIS CREDIT CARD HAS BEEN LOCKED\nContact bank support for more information", "Error", 
					JOptionPane.WARNING_MESSAGE);
		}
	}
	
	void makeTransaction(String transType, String reID, String loca, String amount, String text)
	{	
		if (sql.transferAmount(usr.getCardNo(), reID, amount))
		{
			sql.logTransaction(transType, usr.getCardNo(), reID, loca, amount, text);
			JOptionPane.showMessageDialog
				(null,"Transfer successfully executed", "Notice", 
					JOptionPane.INFORMATION_MESSAGE);
		}
		else JOptionPane.showMessageDialog(null,"An unexpected error encountered\nNo changes were made", "Error", 
				JOptionPane.WARNING_MESSAGE);
		
		int choices = JOptionPane.YES_NO_OPTION;
		int promptchoice = JOptionPane.showConfirmDialog
			(null, "Make another transaction?\nSelect NO to exit", "Notice", choices);
		
		if (promptchoice == JOptionPane.NO_OPTION)
		{
			MenuUI ui = new MenuUI(sql, usr);
				ui.setVisible(true);
			trans.dispose();
		}
	}
}