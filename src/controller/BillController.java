package controller;
//ekorbi20
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.Bill;

public class BillController {
	private ArrayList<Bill> bills;
    private final File file;

    public BillController() {
        bills = new ArrayList<>();
        file = new File("bills.bin");
        if(file.exists())  readBill();
        
    }

    private void readBill() {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            bills = (ArrayList<Bill>) ois.readObject();
            fis.close();
            ois.close();
        } catch(Exception i) {
            System.out.println(i.getMessage());
        }

    }

 
    public void addBill(Bill bill) {
        bills.add(bill);
        writeFile(bill);
    }

    public void writeFile(Bill bill) {
        try {
            File fl = new File("bill");
            fl.mkdir();
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File(fl+ "/bill.txt"), true));
            pw.println(bill.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error!");
        }
    }

}
