package backend_functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SQLQueryEngine
{
	private Connection conn;
	private Statement statement;
	public SQLQueryEngine() {}
	
	public boolean checkConnection()
	{
		try 
		{ 
			conn = DriverManager.getConnection(SQLConstraints.ADDRESS);
			statement = conn.createStatement();
			
			if (conn.isValid(5)) 
			{
				JOptionPane.showMessageDialog(null,"Our system is currently down. Please try again later!", "Alert", 
						JOptionPane.WARNING_MESSAGE);
				
				return false;
			}
		}
		catch (Exception e) {}
		return true;
	}
	
	public boolean loginCheckCredentials(String cardNo, char[] pin)
	{
		String query = "select card_number, pin_code from";
		return true;
	}
}

class SQLConstraints
{
	protected static final String 
		ADDRESS = "jdbc:sqlserver://localhost:3306;"
					+ "databaseName=BikeStores;"
						+ "user=sa;"
							+ "password=mysqllit1765";
}