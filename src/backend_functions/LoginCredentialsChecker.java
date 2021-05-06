package backend_functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ui.LoginWindow;

public class LoginCredentialsChecker implements ActionListener
{
	private LoginWindow logWin;
	public LoginCredentialsChecker(LoginWindow lw) { this.logWin = lw; }
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
	//	if (!logWin.getQueryEngine().checkConnection()) return;
	//	if (checkInputs()) 
	//			if (logWin.getQueryEngine().loginCheckCredentials(logWin.getCardNumber(), logWin.getCardPIN())) 
		if (checkInputs()) logWin.showUI();
	}
	
	public boolean checkInputs() 
	{
		boolean flag = false;
		
		if (logWin.getCardNumber().isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Card number field can not be empty!", "Error", 
				JOptionPane.WARNING_MESSAGE);
		}
		
		else if (logWin.getCardNumber().length() != 16)
		{
			JOptionPane.showMessageDialog(null, "Incorrect card number: It must have 16 digits!", "Error", 
				JOptionPane.WARNING_MESSAGE);
		}
		
		else if (checkPassword()) flag = true;
		
		return flag;
	}
	
	public boolean checkPassword()
	{
		if (logWin.getCardPIN().length == 0) 
		{
			JOptionPane.showMessageDialog(null,"Password can not be empty!", "Error", 
				JOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		
		else if (logWin.getCardPIN().length != 6)
		{
			JOptionPane.showMessageDialog(null,"Incorrect Password", "Warning", 
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else return true;
	}
}