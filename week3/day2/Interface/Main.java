package week3.day2.Interface;

public class Main {
public static void main(String[] args) {
		
	
	Concrete c=new Concrete();
	
	c.connect();
	System.out.println();
	
	c.disconnect();
	System.out.println();
	
	c.executeUpdate();
	System.out.println();
	

}
}