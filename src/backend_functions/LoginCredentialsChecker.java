package backend_functions;

import java.awt.event.ActionEvent;
import java.util.regex.*;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ui.LoginWindow;

public class LoginCredentialsChecker implements ActionListener
{
	private LoginWindow logWin;
	private SQLQueryClient sql;
	private String cardNo, pin;
	private int attempt = 0;
	
	public LoginCredentialsChecker(LoginWindow lw) 
	{ 
		this.logWin = lw;
		this.sql = logWin.getQueryEngine();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		cardNo = logWin.getCardNumber(); pin = logWin.getCardPIN();
		if (sql.testConnection())
		{
			if (checkInputs())
			{
				if (!sql.checkLock(cardNo))
				{
					if (sql.loginCheckCardNumber(cardNo)) 
					{
						if (sql.loginCheckCardPIN(pin)) 
						{
							User us = new User(cardNo, pin, logWin.getUserLocation());
							us.setName(sql.getCardOwnerName(cardNo));
							logWin.showUI(us);
							attempt = 0;
						}
						else 
						{
							attempt++;
							JOptionPane.showMessageDialog(null,"Incorrect PIN code", "Error", 
								JOptionPane.WARNING_MESSAGE);
						}
						if (attempt == 3) sql.lockCard(cardNo);
					}
					else JOptionPane.showMessageDialog(null,"Card number does not exist", "Error", 
							JOptionPane.WARNING_MESSAGE);
				}
				else JOptionPane.showMessageDialog(null,"This Credit Card has been LOCKED\nContact Bank Support for more information", "WARNING", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
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
		if (logWin.getCardPIN().length() == 0) 
		{
			JOptionPane.showMessageDialog(null,"PIN code can not be empty! Please try again", "Error", 
				JOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		
		else if (logWin.getCardPIN().length() < 6)
		{
			JOptionPane.showMessageDialog(null,"PIN code is too short! Please try again", "Warning", 
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		else if (logWin.getCardPIN().length() > 6)
		{
			JOptionPane.showMessageDialog(null,"PIN code is too long! Please try again", "Warning", 
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		else if (!Pattern.matches("[0-9]+", pin)) 
		{
			JOptionPane.showMessageDialog(null,"PIN code contains special characters! Only numeric digits from 0 to 9 is permitted", "Error", 
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		else return true;
	}
}