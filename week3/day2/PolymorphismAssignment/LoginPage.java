package week3.day2.PolymorphismAssignment;

public class LoginPage  extends BasePage{
	@Override
	public void performCommonTasks() {
		System.out.println("perform the commontasks completed");
	}
	
	public static void main(String[] args) {
		LoginPage l=new LoginPage();
		l.findElement();
		l.clickElement();
		l.entertext();
		l.performCommonTasks();
	}
	}
	

