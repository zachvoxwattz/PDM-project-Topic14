package ui;

import java.awt.EventQueue;

import backend_functions.SQLQueryClient;

public class AppLauncher
{
	public static void main(String[] r)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run() 
			{
				SQLQueryClient sql = new SQLQueryClient();
				LoginWindow logWin = new LoginWindow(sql);	
					logWin.setVisible(true);
			}
		});
	}
}