package backend_functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SQLQueryClient
{
	private Connection conn;
	private Statement state;
	
	public SQLQueryClient() {}
	
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
		String query = SQLConst.getCardOwnerNameQuery(c);
		
		try ( ResultSet returnData = state.executeQuery(query); )
		{ if (returnData.next()) name = returnData.getString(1); }
		catch (Exception e) { e.printStackTrace(); }
		
		closeComms();
		return name;
	}
	
	public void transferAmount(String cardNo, String targetID, String amount)
	{
		long useroldamount = getCardBalance(cardNo);
		long usernewamount = useroldamount - Long.parseLong(amount);
		long targetoldamount = getBalanceViaID(targetID);
		long targetnewamount = targetoldamount + Long.parseLong(amount);
		
		
		String query1 = SQLConst.getBalanceUpdateQuery(cardNo, String.valueOf(usernewamount));
		try { iniConnect(); state.executeUpdate(query1); } catch (Exception e) { e.printStackTrace(); }
		
		String query2 = SQLConst.getBalanceUpdateViaIDQuery(targetID, String.valueOf(targetnewamount));
		try { iniConnect(); state.executeUpdate(query2); } catch (Exception e) { e.printStackTrace(); }
	}
	
	public boolean checkCardBalance(String card, String targetamount)
	{
		boolean accepted = false;
		iniConnect();
		String query = SQLConst.getCardBalanceQuery(card);
		try ( ResultSet retDat = state.executeQuery(query); )
		{ 
			if (retDat.next())
			{
				long curramount = Long.parseLong(retDat.getString(1));
				long taramount = Long.parseLong(targetamount);
				
				if (curramount - taramount >= 29000) accepted = true;
			}
		}
		catch (Exception e) { e.printStackTrace(); }
		
		closeComms();
		return accepted;
	}
	
	private long getCardBalance(String card)
	{
		iniConnect();
		long returner = 0;
		
		String query = SQLConst.getCardBalanceQuery(card);
		try ( ResultSet retDat = state.executeQuery(query); ) 
			{ if (retDat.next()) returner = Long.parseLong(retDat.getString(1)); }
		catch (Exception e) { e.printStackTrace(); }
		
		closeComms();
		return returner;
	}
	
	private long getBalanceViaID(String ID)
	{
		iniConnect();
		String returner = "";
				
		String query = SQLConst.getBalanceViaIDQuery(ID);
		try ( ResultSet retDat = state.executeQuery(query); ) 
			{ if (retDat.next()) returner = retDat.getString(1); }
		catch (Exception e) { e.printStackTrace(); }
		
		closeComms();
		long res = Long.parseLong(returner);
		 System.out.println(returner);
		return res;
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
	
	public static String getCardOwnerNameQuery(String c)
	{
		String res = "select accountName from accounts a, cards c where a.cardsetUUID = c.cardsetUUID and cardNo = '" + c + "'";
		return res;
	}
	
	public static String getCardBalanceQuery(String c)
	{
		String res = "select balance from cards c where c.cardNo = '" + c + "'";
		return res;
	}
	
	public static String getBalanceViaIDQuery(String c)
	{
		String res ="select sum(balance) from cards c, accounts a where a.accountID = '" + c + "' and c.cardsetUUID = a.cardsetUUID";
		return res;
	}
	
	public static String getBalanceUpdateQuery(String b, String c)
	{
		String res = "update cards set balance = '" + c + "' where cardNo = '" + b + "'";
		return res;
	}
	
	public static String getBalanceUpdateViaIDQuery(String ID, String amount)
	{
		String res = "update cards as c inner join accounts as a on c.cardsetUUID = a.cardsetUUID set c.balance = '" + amount + "' where a.accountID = '" + ID + "' and c.isDefault = 'YES'";
		
		System.out.println(amount);
		return res;
	}
}