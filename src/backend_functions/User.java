package backend_functions;

public class User
{
	private String cardNo, pin, name, location;
	
	public User(String card, String pin, String location) { this.cardNo = card; this.pin = pin; this.location = location; }
	
	public void setName(String s) { this.name = s; }
	
	public String getLocation() { return this.location; }
	public String getName() { return this.name; }
	public String getCardNo() { return this.cardNo; }
	public String getCardPIN() { return this.pin; }
}