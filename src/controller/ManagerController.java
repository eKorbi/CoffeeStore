package controller;
//ekorbi20
import java.io.File;
import java.util.ArrayList;

import model.Manager;

public class ManagerController {
	private ArrayList<Manager> manager;
	private ArrayList<CashierController> cashierController;
	File file;
	
	public ManagerController() {
		manager = new ArrayList<Manager>();
	}

	public ArrayList<Manager> getManager() {
		return manager;
	}

	public void setManager(ArrayList<Manager> manager) {
		this.manager = manager;
	}
	
}
