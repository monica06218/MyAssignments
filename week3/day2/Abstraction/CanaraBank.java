package week3.day2.Abstraction;


//Step 2: Abstract Class implementing Payments
abstract class CanaraBank implements Payments {
 public void recordPaymentDetails(String paymentType, double amount) {
     System.out.println("Payment recorded:");
     System.out.println("Type: " + paymentType);
     System.out.println("Amount: ₹" + amount);
 }
}
 