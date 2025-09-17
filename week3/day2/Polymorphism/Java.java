package week3.day2.Polymorphism;

public class Java {

	// reportStep method
	public void reportStep(String msg, String status) {
		System.out.println(msg+":"+status);
	}

	// reportStep method with different arguments
	public void reportStep(String msg, String status, boolean snap) {
		System.out.println(msg+":" + status +":"+ snap);

	}

	// main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Java j = new Java();
		j.reportStep("executed", "success");
		j.reportStep("executed", "success", true);

	}

}
