package model;
//ekorbi20
public class Manager extends User {
private String access_level; 
	
	public Manager(String access, String name, String surname, String email) {
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
		return "Manager [access_level=" + access_level + "]";
	}
}
