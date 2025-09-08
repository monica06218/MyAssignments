package week2.day1;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 8, a = 0, b = 1, temp;
		for (int i = 0; i < N; i++) {
			System.out.println(a);

			temp = a + b;
			a = b;
			b= temp;
		

		}

	}

}
