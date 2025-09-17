package week3.day1;

import week3.day1.inheritance.Button;
import week3.day1.inheritance.CheckBoxButton;
import week3.day1.inheritance.Execution;
import week3.day1.inheritance.RadioButton;
import week3.day1.inheritance.TextField;

public class Demo {
	public static void main(String[] args) {
		//Creating TextField Object
		TextField t=new TextField();
		t.getText();
		t.click();
		t.setText("Text");
		
		
		//Creating Button Object
		Button b=new Button();
		b.submit();
		b.click();
		b.setText("Text");
		
		//Creating CheckBoxButton Object
		CheckBoxButton c=new CheckBoxButton();
		c.submit();
		c.clickCheckButton();
		
		//Creating RadioButton Object
				RadioButton r=new RadioButton();
				r.submit();
				r.selectRadioButton();
				
		//Creating Execution Object
				Execution e=new Execution();
				c.submit();
				

	}
}
