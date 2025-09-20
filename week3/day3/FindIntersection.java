package week3.day3;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//declare an array
          int a[]={3, 2, 11, 4, 6, 7};
          int b[]={1, 2, 8, 4, 9, 7};
          //create a list
          List<Integer> c=new ArrayList<>();
          List<Integer> d=new ArrayList<>();
          //add elements into a list
          for(int num:a) {
        	  c.add(num);
          }
          for(int num1:b) {
        	  d.add(num1);
          }
          //iterate through the loop and get the matching elements
          for(int i=0;i<c.size();i++) {
        	for(int j=0;j<d.size();j++) {
        		if(c.get(i)== d.get(j)) {
        			System.out.println(c.get(i));
        		}
        		
        	}
        	  
          }
	}

}
