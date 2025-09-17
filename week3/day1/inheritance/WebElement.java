package week3.day1.inheritance;
//superclass
public class WebElement {

	//Click() method is created
	public void click() {
		System.out.println("button is clicked");
	}
	//setter is used to set the name for the element	
	public void setText(String text) {
	       System.out.println("setting Text:"+text);
	        
	}
	//getter is used to get the element
public void getText() {
	System.out.println("getting  the text from element");
}
	}


