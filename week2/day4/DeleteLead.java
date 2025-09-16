package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//step 1:Initialize the WebDriver (ChromeDriver).
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		// step 2 : load the url using .get() and maximize the window
		driver.get("http://leaftaps.com/opentaps");
		//step 3: Maximize the browser window.
		driver.manage().window().maximize();
		//step 4:locate the username field
		WebElement userName = driver.findElement(By.id("username"));
		//step 5:Enter the valid username
		userName.sendKeys("demosalesmanager");
		//step 6:enter the password
		WebElement password = driver.findElement(By.name("PASSWORD"));
		//step 7:enter valid password
		password.sendKeys("crmsfa");
		//step 6:click the login button
		WebElement Login=driver.findElement(By.className("decorativeSubmit"));
		Login.click();
		//step 7:click the link tag i.e CRM
		driver.findElement(By.partialLinkText("CRM")).click();
		//step 8:click the leads link
		driver.findElement(By.linkText("Leads")).click();
		//step 9: click "Find leads" button
		driver.findElement(By.linkText("Find Leads")).click();
		//step 10:click on the phone tab
	    driver.findElement(By.xpath("//span[text()='Phone']")).click();
		//step 11:locate the phoneareacode
		WebElement phoneareacode = driver.findElement(By.name("phoneAreaCode"));
		//step 12: enter the phoneareacode
		phoneareacode.sendKeys("+91");
		WebElement phonenumber = driver.findElement(By.name("phoneNumber"));
		//step 12: enter the phonenumber
		phonenumber.sendKeys("1234567891");
		//step 13: click "Find leads" button
		driver.findElement(By.linkText("Find Leads")).click();
		//step 14:capture the lead id of first resulting id and click
	    String leadid=driver.findElement(By.xpath(("(//a[@class='linktext'])[4]"))).getText();
	    System.out.println(leadid);
	    driver.findElement(By.xpath(("(//a[@class='linktext'])[4]"))).click();
	    //step 15:click delete button
	    driver.findElement(By.linkText("Delete")).click();
	    //step 16 : click find the leads again
	    driver.findElement(By.linkText("Find Leads")).click();
	    //step 17:enter the captured lead id
	    WebElement id=driver.findElement(By.name("id"));
	    //step 18:valid the lead id
	    id.sendKeys(leadid);
	   //step 20:click find leads again
	    driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	    Thread.sleep(2000);
	    //step 21:verify the presence of message"no record to display
	  String pageinfo = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		 
		 if (pageinfo.equals("No records to display")) {
			 System.out.println("Lead id successfully deleted");
		 }
			 else {
				 System.out.println("deletion not successfull");
			 } 
	   
	    
	    
	   
		
		
	

	}

}
