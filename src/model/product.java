package model;
//ekorbi20
import java.time.LocalDate;

public class product {
	private String name;
	private String id;
	private double sellPrice;
	private int quantity;
	
	public product(String id, String name , int quantity) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}
	public product(String id, String name, double sellPrice) {
		quantity = 0;
		this.id = id;
		this.name = name;
		this.sellPrice = sellPrice;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [ID=" + id + ", name=" + name + ", quantity=" + quantity + ", "
				+ ", sell Price=" + sellPrice + "]";
	}

}
