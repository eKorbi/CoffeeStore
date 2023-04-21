package model;
//ekorbi20
public class Cashier extends User{
private String access_level; 
	
	public Cashier(String access, String name, String surname, String email)
	{
		super(name, surname, email, access);
	}

	public String getAccess_level() {
		return access_level;
	}

	public void setAccess_level(String access_level) {
		this.access_level = access_level;
	}

	@Override
	public String toString() {
		return "Cashier [access_level=" + access_level + "]";
	}
}
