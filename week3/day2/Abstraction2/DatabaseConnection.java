package week3.day2.Abstraction2;

public interface DatabaseConnection {
	void connect() ;
	void disconnect(); 
	void executeUpdate();

}
