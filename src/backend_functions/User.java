package backend_functions;

public class User
{
	private String cardNo, pin, name;
	
	public User(String card, String pin) { this.cardNo = card; this.pin = pin; }
	
	public void setName(String s) { this.name = s; }
	
	public String getName() { return this.name; }
	public String getCardNo() { return this.cardNo; }
	public String getCardPIN() { return this.pin; }
}