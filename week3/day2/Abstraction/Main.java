package week3.day2.Abstraction;

public class Main {
	public static void main(String[] args) {
		Amazon amazonPayment = new Amazon();

		amazonPayment.cashOnDelivery();
		System.out.println();

		amazonPayment.upiPayments();
		System.out.println();

		amazonPayment.cardPayments();
		System.out.println();

		amazonPayment.internetBanking();
	}

}
