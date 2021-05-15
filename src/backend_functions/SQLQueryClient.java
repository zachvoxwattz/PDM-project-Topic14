package backend_functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JOptionPane;

import ui.HistoryUI;

public class SQLQueryClient
{
	private Connection conn;
	private Statement state;
	
	public SQLQueryClient() {}
	
	private void iniConnect()
	{
		try 
		{ 
			conn = DriverManager.getConnection(SQLConst.LOCAL_ADDRESS, SQLConst.USER, SQLConst.PASSWORD);
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
	
	public boolean transferAmount(String cardNo, String targetID, String amount)
	{
		boolean success = false;
		long useroldamount = getCardBalance(cardNo);
		long usernewamount = useroldamount - Long.parseLong(amount);
		long targetoldamount = getCardBalanceViaID(targetID);
		long targetnewamount = targetoldamount + Long.parseLong(amount);
		
		String query1 = SQLConst.getBalanceUpdateQuery(cardNo, String.valueOf(usernewamount));
		try { iniConnect(); state.executeUpdate(query1); } catch (Exception e) { e.printStackTrace(); }
		
		String query2 = SQLConst.getBalanceUpdateViaIDQuery(targetID, String.valueOf(targetnewamount));
		try { iniConnect(); state.executeUpdate(query2); success = true; } catch (Exception e) { e.printStackTrace(); }
		
		return success;
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
	
	public void logTransaction(String type, String cardNo, String reID, String location, String amount, String text)
	{
		iniConnect();
		String accID = getAccountID(cardNo);
		String query = SQLConst.getLogTransactionQuery(type, accID, cardNo, reID, location, amount, text);
		
		try { state.executeUpdate(query); } catch (Exception e) { e.printStackTrace(); }
	}
	
	private String getAccountID(String card)
	{
		iniConnect();
		String query = SQLConst.getAccountIDQuery(card);
		String acc = "";
		
		try { ResultSet ret = state.executeQuery(query); if (ret.next()) acc = ret.getString(1); } catch (Exception e) { e.printStackTrace(); }
		
		return acc;
	}
	
	public void getTransactions(User us, HistoryUI h)
	{
		iniConnect();
		String query = SQLConst.getTransactionsQuery(us.getCardNo());
		
		try 
		{ 
			List<String> c = new ArrayList<>();
			List<String> d = new ArrayList<>();
			
			ResultSet rs = state.executeQuery(query); 
			ResultSetMetaData rsmd = rs.getMetaData();
			int col_no = rsmd.getColumnCount();
			
			for (int i = 1; i <= col_no; i++) c.add(rsmd.getColumnLabel(i));
			
			while (rs.next()) 
				for (int i = 1; i <= col_no; i++) 
				{
					String sample = rs.getString(i);
						if (sample == null) d.add("NULL");
						else d.add(rs.getString(i));
				}
			h.showTable(c, d);
		}
		catch (Exception e) {}
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
	
	private long getCardBalanceViaID(String ID)
	{
		iniConnect();
		String returner = "";
				
		String query = SQLConst.getCardBalanceViaIDQuery(ID);
		try ( ResultSet retDat = state.executeQuery(query); ) 
			{ if (retDat.next()) returner = retDat.getString(1); }
		catch (Exception e) { e.printStackTrace(); }
		
		closeComms();
		long res = Long.parseLong(returner);
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
	protected static final String LOCAL_ADDRESS = "jdbc:mysql://192.168.100.17/pdm_topic14";
	protected static final String USER = "pdm_guest";
	protected static final String PASSWORD = "mysqllit1765";
	
	protected static String loginCardNoQuery(String cardno)
	{
		String res = "select cardNo, pin from cards where cardNo = '" + cardno + "'";
		return res;
	}
	
	protected static String loginCardPINQuery(String pin)
	{
		String res = "select pin from cards where pin = '" + pin + "'";
		return res;
	}
	
	protected static String getCardOwnerNameQuery(String c)
	{
		String res = "select accountName from accounts a, cards c where a.cardsetUUID = c.cardsetUUID and cardNo = '" + c + "'";
		return res;
	}
	
	protected static String getCardBalanceQuery(String c)
	{
		String res = "select balance from cards c where c.cardNo = '" + c + "'";
		return res;
	}
	
	protected static String getCardBalanceViaIDQuery(String c)
	{
		String res ="select balance from cards c, accounts a where c.cardsetUUID = a.cardsetUUID and a.accountID = '" + c + "' and c.isDefault = 'YES';";
		return res;
	}
	
	protected static String getBalanceUpdateQuery(String cardNo, String amount)
	{
		String res = "update cards set balance = '" + amount + "' where cardNo = '" + cardNo + "'";
		return res;
	}
	
	protected static String getBalanceUpdateViaIDQuery(String ID, String amount)
	{
		String res = "update cards as c inner join accounts as a on c.cardsetUUID = a.cardsetUUID set c.balance = '" + amount + "' where a.accountID = '" + ID + "' and c.isDefault = 'YES'";
		return res;
	}
	
	protected static String getLogTransactionQuery(String type, String accID, String cardNo, String reID, String location, String amount, String text)
	{
		String uuid = UUID.randomUUID().toString();
		
		String res = "insert into transactions value ('" + uuid + "', '" + type + "', '" + accID + "', '" + cardNo + "', '" + reID + "', '" + location + "', current_timestamp, '" + amount + "', '" + text + "')";
		
		return res;
	}
	
	protected static String getAccountIDQuery(String cardNo)
	{
		String res = "select accountID from accounts a, cards c where a.cardsetUUID = c.cardsetUUID and c.cardNo = '" + cardNo +"'";
		return res;
	}
	
	protected static String getTransactionsQuery(String cardNo)
	{
		String res = "select ID, typeName as TransactionType, accountID as AccountNumber, cardNo as CardNumber, recipientID as ReceiverNumber, locationName as Location, date as Date, amount as Amount, comment as Notes from transactions t, locations l, transtypes tt where t.locationID = l.locationID and tt.typeID = t.typeID and t.accountID in (select accountID from accounts a, cards c where a.cardsetUUID = c.cardsetUUID and c.cardNo = '" + cardNo + "')";
		
		return res;
	}
}