package week2.day2;

public class Stringmanipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "changeme";
		char[] charArray=test.toCharArray();
		for(int i = charArray.length - 1; i >= 0; i--) {
	        if (i % 2 != 0) { // Check if the index is odd
	            //System.out.println("Character at odd index " + i + ": " + charArray[i]);
	         charArray[i]=  Character.toUpperCase(charArray[i]);
	           }
		}       
		
		
		//String myString = String.valueOf(charArray);
		System.out.println(charArray);
		
		
	}

}
