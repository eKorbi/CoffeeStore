package model;
//ekorbi20
public class Administrator extends User{
private String accessLevel;
	
	public Administrator(String name, String surname, String email, String access) {
		super(name, surname, email, access);
	}

	public String getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	@Override
	public String toString() {
		return "Administrator [accessLevel=" + accessLevel + "]";
	}

}
