package week2.day2;

import java.util.Arrays;

public class FindMissingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 4, 3, 2, 8, 6, 7 };
		Arrays.sort(a);
		for (int i = 0; i < a.length-1; i++) {
			if (a[i + 1] - a[i] > 1) {
				System.out.println(a[i] + 1);
				break;
			}

		}
	}
}