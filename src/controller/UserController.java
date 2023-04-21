package controller;
//ekorbi20
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.User;

public class UserController {
	private ArrayList<User> users;
	private File file;
	public UserController(){
		users= new ArrayList<>();
		file= new File("users.bin");
		if(file.exists()){
			readUsers();
		}
	}

	private void readUsers() {
		try{
			FileInputStream fis= new FileInputStream(file);
			ObjectInputStream ois= new ObjectInputStream(fis);
			users=(ArrayList<User>) ois.readObject();
			fis.close();
			ois.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	private void writeUsers() {
		try{
			FileOutputStream fos= new FileOutputStream(file);
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			oos.writeObject(users);
			oos.close();
			fos.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

 void addUser(User u){
		users.add(u);
	}
	public boolean signUp(String name, String surname, String email, String password,String verifyPassword, String access){
		if(password.equals(verifyPassword)){
			User u = new User(name, surname, email, access);
			addUser(u);
			writeUsers();
			return true;
		}
		return false;
	}
	
	
	public User login(String email, String password){
		System.out.println("Users:"+ this.users);
		for(User user: users){
			if(user.getEmail().equals(email) && user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
	
	public ArrayList<User> getUsers(){
		return this.users;
	}
	
	public void editUser(User updatedUser, int index){
		this.users.set(index, updatedUser);
		writeUsers();
	}
	
	public int positionOfUser(User currentUser) {
		for(int i=0 ; i<this.users.size(); i++) {
			if(currentUser.getEmail().equals(this.users.get(i).getEmail())){
				return i;
			}
		}
		return -1;
	}
}
