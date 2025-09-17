package week3.day2.Abstraction;

//Create Concrete Class

public class Amazon  extends CanaraBank{

	@Override
	public void cashOnDelivery() {
		// TODO Auto-generated method stub
		  System.out.println("Processing Cash on Delivery...");
	        recordPaymentDetails("Cash on Delivery", 1500.00);
		
	}

	@Override
	public void upiPayments() {
		// TODO Auto-generated method stub
		System.out.println("Processing UPI Payment...");
        recordPaymentDetails("UPI", 799.99);
		  
		
	}

	@Override
	public void cardPayments() {
		// TODO Auto-generated method stub
		System.out.println("Processing Card Payment...");
        recordPaymentDetails("Card", 1299.49);
		
	}

	@Override
	public void internetBanking() {
		// TODO Auto-generated method stub
		  System.out.println("Processing Internet Banking Payment...");
	        recordPaymentDetails("Internet Banking", 2200.00);
	}

}
