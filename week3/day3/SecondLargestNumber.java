package week3.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondLargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//declare an array
		int a[]= {3, 2, 11, 4, 6, 7};
		//create a list
		List<Integer> b=new ArrayList<>();
		//add all elements in to list
		for(int num:a) {
			b.add(num);
		}
		//sort the list in descending order
		   Collections.sort(b, Collections.reverseOrder());

	        // The second largest will be at index 1 now
	        System.out.println("Second largest element is: " + b.get(1));
		 
				
		}
	}


