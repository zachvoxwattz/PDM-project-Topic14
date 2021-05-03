package ui;

import java.awt.EventQueue;

public class AppLauncher
{
	public static void main(String[] r)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run() 
			{
				LoginWindow logWin = new LoginWindow();	
					logWin.setVisible(true);
			}
		});
	}
}
