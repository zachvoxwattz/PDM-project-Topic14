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
	
	public TransferFunction(SQLQueryClient s, User us, TransferUI base)
	{
		this.sql = s;
		this.usr = us;
		this.trans = base;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cardNo = usr.getCardNo();
		String reID = trans.getRecipientID();
		String amount = trans.getTransferAmount();
		String text = trans.getComments();
		String location = "8_10";
		String transType = "TS";
		
		if (sql.testConnection())
		{
			if (sql.checkCardBalance(usr.getCardNo(), trans.getTransferAmount()))
			{
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog
					(null, "Confirm transfering to this account?\nSelect NO to review your information", "Notice", dialogButton);
				
				if (dialogResult == 0) 
				{
					if (sql.transferAmount(cardNo, reID, amount))
					{
						sql.logTransaction(transType, cardNo, reID, location, amount, text);
						JOptionPane.showMessageDialog
							(null,"Transfer successfully executed", "Notice", 
								JOptionPane.INFORMATION_MESSAGE);
					}
					
					int choices = JOptionPane.YES_NO_OPTION;
					int promptchoice = JOptionPane.showConfirmDialog
						(null, "Make another transaction?", "Notice", choices);
					
					if (promptchoice == JOptionPane.NO_OPTION)
					{
						MenuUI ui = new MenuUI(sql, usr);
							ui.setVisible(true);
						trans.dispose();
					}
				}
			}
			
			else JOptionPane.showMessageDialog(null,"Insufficient funds to perform this action!", "Error", 
					JOptionPane.WARNING_MESSAGE);
		}
	}
}