package week3.day2.Interface;

public class Concrete implements DatabaseConnection {

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("database Connected..");
		
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		System.out.println("datbase disconnected..");
		
	}

	@Override
	public void executeUpdate() {
		// TODO Auto-generated method stub
		System.out.println("updated the execution");
		
	}
	
}
