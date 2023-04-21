package model;
//ekorbi20
import java.io.Serializable;

public class User implements Serializable{
private String name, surname, password, phone, email, access;
	
	private double salary;
	private String birthday;
	private static int nrUsers=0;
	
	public User(String name, String surname, String email, String access) {
		nrUsers++;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.access=access;
	}

	public void setAccess(String access) {
		this.access = access;
	}
	
	public String getAccess() {
		return access;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public static int getNrUsers() {
		return nrUsers;
	}

	public static void setNrUsers(int nrUsers) {
		User.nrUsers = nrUsers;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", phone=" + phone + ", email=" + email
			 + ", salary=" + salary + ", birthday=" + birthday + "]";
	}
	
}
