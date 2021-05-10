package backend_functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
		if (sql.testConnection())
		{
			if (sql.checkCardBalance(usr.getCardNo(), trans.getTransferAmount()))
			{
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog
					(null, "Confirm transfering to this account?\nSelect NO to review your information", "Notice", dialogButton);
				
				if (dialogResult == 0) 
				{
					sql.transferAmount(usr.getCardNo(), trans.getRecipientID(), trans.getTransferAmount());
					JOptionPane.showMessageDialog(null,"Transfer successfully executed", "Notice", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
			else JOptionPane.showMessageDialog(null,"Insufficient funds to perform this action!", "Error", 
					JOptionPane.WARNING_MESSAGE);
		}
	}
}