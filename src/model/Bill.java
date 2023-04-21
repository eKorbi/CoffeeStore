package model;
//ekorbi20
import java.time.LocalDate;

public class Bill {
	 private static int billNumber=0;
	    private String billName;
	    private LocalDate billDate;
	    private double price;
	    int quantitySold;

		public Bill(String cashierUsername, LocalDate billDate, double total, int quantity) {
			this.billName = cashierUsername;
			this.billDate = billDate;
			this.price = total;

			quantitySold = quantity;
			++billNumber;
		}
		
		public static int getBillNo() {
			return billNumber;
		}
		
		public String getCashierUsername() {
			return billName;
		}
		
		public LocalDate getBillDate() {
			return billDate;
		}
		
		public double getTotal() {
			return price;
		}
		
		@Override
		public String toString() {
			return "Bill \n"+"billName=" + billName  + "\n billDate=" + billDate + "\n price="
					+ price + "\n quantitySold=" + quantitySold+"\n\n";
		}
}
