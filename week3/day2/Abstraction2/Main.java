package week3.day2.Abstraction2;

public class Main {
    public static void main(String[] args) {
        JavaConnection connection = new JavaConnection();

        connection.connect();
        connection.executeQuery();
        connection.executeUpdate();
        connection.disconnect();
    }
}