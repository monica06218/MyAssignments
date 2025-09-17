package week3.day2.PolymorphismAssignment;

public class APIClient {

	//create a method sendrequest
	public void sendRequest(String endpoint) {
		System.out.println("Sending request to:"+endpoint);
		
	}
	public void sendRequest(String endpoint,String Requestbody,boolean requestStatus) {
		System.out.println("Sending request to:"+endpoint);
		System.out.println("Request Body:"+Requestbody);
		System.out.println("Request Status: "+ (requestStatus ? "Success" : "Failure"));
		
		
	}
}

