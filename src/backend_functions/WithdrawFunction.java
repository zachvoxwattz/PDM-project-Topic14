package backend_functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ui.MenuUI;
import ui.WithdrawalUI;

public class WithdrawFunction implements ActionListener 
{
	private SQLQueryClient sql;
	private User user;
	private WithdrawalUI wu;
	
	public WithdrawFunction(SQLQueryClient sql, User us, WithdrawalUI w)
	{
		this.sql = sql;
		this.user = us;
		this.wu = w;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String amount = wu.getAmount();
		String type = "WD";
		
		if (sql.testConnection())
		{
			if (!sql.checkLock(user.getCardNo()))
			{	
				if (sql.checkCardBalance(user.getCardNo(), amount))
				{
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog
						(null, "Confirm withdrawing from this account?", "Notice", dialogButton);
					
					if (dialogResult == 0) 
					{
						if (sql.checkUsage(user.getCardNo(), amount) || sql.checkLocation(user.getLocation()))
						{
							int attempt = 0;
							String accountID = JOptionPane.showInputDialog
									(null,"Verification Required! Please enter your AccountID below", "Notice", 
											JOptionPane.INFORMATION_MESSAGE);
							
							if (accountID.equals(sql.getAccountNo(user.getCardNo())))
							{
								makeTransaction(amount, type);
							}
							
							else attempt++;
							
							if (attempt == 5) 
							{
								JOptionPane.showMessageDialog(null,"FAILED AFTER 5 Attempts. This Credit Card has been LOCKED\nContact Bank Support for more information", "WARNING", 
										JOptionPane.WARNING_MESSAGE);
								sql.lockCard(user.getCardNo());
							}
						}
						else makeTransaction(amount, type);
					}
				}
				
				else JOptionPane.showMessageDialog(null,"Insufficient funds to perform this action!", "Error", 
						JOptionPane.WARNING_MESSAGE);
			}
			
			else JOptionPane.showMessageDialog(null,"THIS CREDIT CARD HAS BEEN LOCKED\nContact bank support for more information", "Error", 
					JOptionPane.WARNING_MESSAGE);
			// TODO Auto-generated method stub
		}
	}
	
	public void makeTransaction(String amount, String type)
	{
		if (sql.withdrawAmount(user.getCardNo(), amount))
		{
			sql.logTransaction(type, user.getCardNo(), user.getLocation(), amount, "Withdrawal from account");
			JOptionPane.showMessageDialog
				(null,"Withdrawal Completed\nThank you for using our service!", "Notice", 
					JOptionPane.INFORMATION_MESSAGE);
		}
		
		else JOptionPane.showMessageDialog(null,"An unexpected error encountered\nNo changes were made", "Error", 
				JOptionPane.WARNING_MESSAGE);
		
		int choices = JOptionPane.YES_NO_OPTION;
		int promptchoice = JOptionPane.showConfirmDialog
			(null, "Make another transaction?\nSelect NO to exit", "Notice", choices);
		
		if (promptchoice == JOptionPane.NO_OPTION)
		{
			MenuUI ui = new MenuUI(sql, user);
				ui.setVisible(true);
			wu.dispose();
		}
	}
}