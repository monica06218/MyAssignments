package week3.day2.Abstraction2;

// Concrete method added by abstract class

public  abstract class MySqlConnection implements DatabaseConnection{
	
	//create executeQuery method
	
	public void executeQuery() {
		System.out.println("Executing query in MySQL database");
	}

}
