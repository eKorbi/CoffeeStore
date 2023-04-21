package controller;
//ekorbi20
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Cashier;

public class CashierController {
	private ArrayList<Cashier> cashier;
	File file;
	private int nrBills=0;
	
	public CashierController() {
		cashier = new ArrayList<Cashier>();
	}
	
	public void createBill(Cashier cashier) throws FileNotFoundException, IOException{
		file = new File("data.bin");
		FileOutputStream fos = new FileOutputStream(file); 
		ObjectOutputStream oos = new ObjectOutputStream(fos); 
		oos.writeObject(cashier);
		fos.close();
		oos.close();
		nrBills++;
	}
	
	public ArrayList<Cashier> getCashier() {
		return cashier;
	}

	public void setCashier(ArrayList<Cashier> cashier) {
		this.cashier = cashier;
	}
	
	public void setNrBills(int nrBills) {
		this.nrBills = nrBills;
	}
	
	public int getNrBills() {
		return this.nrBills;
	}
}
