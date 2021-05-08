package backend_functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SQLQueryEngine
{
	private Connection conn;
	private Statement state;
	
	public SQLQueryEngine() {}
	
	private void iniConnect()
	{
		try 
		{ 
			conn = DriverManager.getConnection(SQLConst.REMOTE_ADDRESS, SQLConst.USER, SQLConst.PASSWORD);
			state = conn.createStatement();
		}
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
			JOptionPane.showMessageDialog
			(null,"Our system is currently down. Please try again later!", "Error", 
			JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public boolean testConnection()
	{
		iniConnect();
		try 
		{ 
			if (conn.isValid(30)) 
			{
				conn.close();
				state.close();
				return true; 
			}
			conn.close(); state.close();
		}
		catch (SQLException e) { e.printStackTrace(); }
		return false;
	}
	
	public boolean loginCheckCredentials(String cardNo, String pin)
	{
		boolean accepted = false;
		
		iniConnect();
		String query = SQLConst.loginQuery(cardNo, pin);
		
		try ( ResultSet returnData = state.executeQuery(query); )
		{
			if (returnData.next())
			{
				String carddb = returnData.getString(1);
				String pindb = returnData.getString(2);
					
				if (cardNo.equals(carddb))
				{
					if (pin.equals(pindb)) accepted = true;
				}
			}
		}
		catch (Exception e) { e.printStackTrace(); }
		return accepted;
	}
	
	void showIncorrectCreds(String a) { JOptionPane.showMessageDialog(null, a, "Error", JOptionPane.WARNING_MESSAGE); }
}

class SQLConst
{
	protected static final String REMOTE_ADDRESS = "jdbc:mysql://dbproject.3utilities.com/pdm_topic14";
	protected static final String LOCAL_ADDRESS = "jdbc:mysql://localhost/pdm_topic14";
	protected static final String USER = "pdm_guest";
	protected static final String PASSWORD = "mysqllit1765";
	
	public static String loginQuery(String a, String b)
	{
		String res = "select cardNo, pin from cards where cardNo = '" + a + "' and pin = '" + b + "'";
		return res;
	}
}