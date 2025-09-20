package week3.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sortusingcollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          //declare an array
		String a[]={"HCL", "Wipro", "Aspire Systems", "CTS"};
		//create a list
		
		List<String> b = new ArrayList<>();
		for(String str:a) {
			b.add(str);
		}
		Collections.sort(b);
		
		//reverse the list and print the values
         for(int i=b.size()-1;i>=0;i--) {
        	 System.out.println(b.get(i));
        	 
         }
	}

}
