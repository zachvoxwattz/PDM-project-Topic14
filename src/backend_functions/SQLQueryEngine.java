package backend_functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.UUID;

public class SQLQueryEngine
{
	private Connection conn;
	public SQLQueryEngine() {}
	
	public void checkConnection()
	{
		try 
		{
			prepConnection();
			System.out.println("Connection successfully established");
			conn.close(); 
		}
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public boolean prepConnection()
	{
		try 
		{
			conn = DriverManager
					.getConnection(SQLConstraints.REMOTE_ADDRESS,
										SQLConstraints.USER, 
											SQLConstraints.PASSWORD);
			System.out.println("Connection successfully established");
		}
		catch (Exception e) {}
		return true;
	}
	
	public boolean loginCheckCredentials(String cardNo, char[] pin)
	{
		return true;
	}
	
	private void addAccounts(String accID, String name, int balance)
	{
		prepConnection();
		String cardUUID = getRandomUUID();
		String query = "insert into accounts(AccountID, AccountName, CardHolderUUID, Balance)" +
		"values('" + accID + "', '" + name + "'. '" + cardUUID + "', '" + balance + "')";
		try ( Statement statement = conn.createStatement(); ) { statement.executeQuery(query); }
		catch (Exception e) { e.printStackTrace(); }
	}
	
	private String getRandomUUID() { return UUID.randomUUID().toString(); }
}

class SQLConstraints
{
	protected static final String REMOTE_ADDRESS = "jdbc:mysql://dbproject.3utilities.com/pdm_topic14";
	protected static final String LOCAL_ADDRESS = "jdbc:mysql://localhost/pdm_topic14";
	protected static final String USER = "pdm_guest";
	protected static final String PASSWORD = "mysqllit1765";
}