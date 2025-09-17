package week3.day2.Polymorphism;

public class subclass  extends Javaformethodovverridding{
 
	@Override
	public void takeSnap(String text) {
		System.out.println("snapshot taken :"+text);
}
	public static void main(String[] args) {
	 subclass s=new subclass ();
	 s.reportStep("reportedthestep");
	 s.takeSnap("snaptaken");
	 s.takeSnap("methoovrrided");
		
	}
}