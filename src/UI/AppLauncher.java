package ui;

import java.awt.EventQueue;

import backend_functions.SQLQueryEngine;

public class AppLauncher
{
	public static void main(String[] r)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run() 
			{
				SQLQueryEngine sql = new SQLQueryEngine(); sql.prepConnection();
				LoginWindow logWin = new LoginWindow(sql);	
					logWin.setVisible(true);
			}
		});
	}
}