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
	
	public boolean loginCheckCardNumber(String cardNo)
	{
		boolean accepted = false;
		
		iniConnect();
		String query = SQLConst.loginCardNoQuery(cardNo);
		
		try ( ResultSet returnData = state.executeQuery(query); )
		{
			if (returnData.next())
			{
				String carddb = returnData.getString(1);
				if (cardNo.equals(carddb)) accepted = true;
			}
			
			closeComms();
		}
		catch (Exception e) { e.printStackTrace(); }
		return accepted;
	}
	
	public boolean loginCheckCardPIN(String pin)
	{
		boolean accepted = false;
		iniConnect();
		String query = SQLConst.loginCardPINQuery(pin);
		
		try ( ResultSet returnData = state.executeQuery(query); )
		{
			if (returnData.next())
			{
				String cardpin = returnData.getString(1);
				if (pin.equals(cardpin)) accepted = true;
			}
		}
		catch (Exception e) { e.printStackTrace(); }
		
		closeComms();
		return accepted;
	}
	
	public String getCardOwnerName(String c)
	{
		iniConnect();
		String name = "";
		String query = SQLConst.getCardOwnerName(c);
		
		try ( ResultSet returnData = state.executeQuery(query); )
		{ if (returnData.next()) name = returnData.getString(1); }
		catch (Exception e) { e.printStackTrace(); }
		
		closeComms();
		return name;
	}
	
	private void closeComms()
	{
		try { conn.close(); state.close(); } catch (Exception e) { e.printStackTrace(); }
	}
}

class SQLConst
{
	protected static final String REMOTE_ADDRESS = "jdbc:mysql://dbproject.3utilities.com/pdm_topic14";
	protected static final String LOCAL_ADDRESS = "jdbc:mysql://localhost/pdm_topic14";
	protected static final String USER = "pdm_guest";
	protected static final String PASSWORD = "mysqllit1765";
	
	public static String loginCardNoQuery(String cardno)
	{
		String res = "select cardNo, pin from cards where cardNo = '" + cardno + "'";
		return res;
	}
	
	public static String loginCardPINQuery(String pin)
	{
		String res = "select pin from cards where pin = '" + pin + "'";
		return res;
	}
	
	public static String getCardOwnerName(String c)
	{
		String res = "select accountName from accounts a, cards c where a.cardsetUUID = c.cardsetUUID and cardNo = '" + c + "'";
		return res;
	}
}