package week3.day2.Abstraction2;

public class JavaConnection extends MySqlConnection {

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		 System.out.println("Connecting to the MySQL database...");
    
		
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		System.out.println("Disconnecting from the MySQL database...");
		
	}

	@Override
	public void executeUpdate() {
		// TODO Auto-generated method stub
		 System.out.println("Executing update on the MySQL database...");
		
	}

	

	}


