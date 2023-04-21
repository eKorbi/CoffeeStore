package controller;
//ekorbi20
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.User;
import model.product;

public class productController {
	private ArrayList<product> products;
	private static final String file="products.bin";
	private File filename;
	
	public productController() {
		products=new ArrayList<>();
		filename=new File(file);
		if(filename.exists()) {
			readProducts();
		} else {
			writeProducts();
		}
	}
	
	public ArrayList<product> getProducts() {
		return products;
	}

	public void addProduct(product product) {
		products.add(product);
		writeProducts();
	}
	
	private void writeProducts() {
		try {
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(products);
			oos.close();fos.close();
		} catch (Exception e) {
			System.err.println("Be Careful!");
		}
	}
	
	private void readProducts() {
		try {
			FileInputStream fis=new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			products=(ArrayList<product>)
			ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.err.println("Be Careful!");
		} 
	}
	
	public boolean useBarcode(String Id) {
		for(product p : products) {
			if((p.getId()).equals(Id)) {
				return true;
			}
		}			
		return false;
	}
	
	public int getPosition(product prod) {
		
		for(int i=0; i<products.size(); i++)	{
			if(products.get(i).getId()==prod.getId())
				return i;	}	
		return -1;
	}
	
	
	

}
