package week3.day2.PolymorphismAssignment;

public class Main  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		APIClient a=new APIClient();
		a.sendRequest("L http://leaftaps.com/opentaps/");
		a.sendRequest("L http://leaftaps.com/opentaps/login","{ \"title\": \"New Post\" } ", true);
		
		

	}

}
