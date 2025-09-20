package week3.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Missingelementfromthelistofintegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declare an array
		int a[] = { 1, 2, 3, 4, 10, 6, 8 };
		// create a list
		List<Integer> b = new ArrayList<>();
		// add elements into a list
		for (int num : a) {
			b.add(num);
		}
		// sort the list in ascending order
		Collections.sort(b);
		// compare the elements to detect a gap and print the missed elements
		for (int i = 0; i < b.size() - 1; i++) {
			if (b.get(i) + 1 != b.get(i + 1)) {
				for (int j = b.get(i) + 1; j < b.get(i + 1); j++) {
					System.out.println(j);

				}
			}
		}

	}
}
