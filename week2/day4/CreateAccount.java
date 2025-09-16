package week2.day4;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//step 1:Initialize the WebDriver (ChromeDriver).
	ChromeOptions options = new ChromeOptions();
	options.addArguments("guest");
	ChromeDriver driver = new ChromeDriver(options);
	// step 2 : load the url using .get() and maximize the window
	driver.get("http://leaftaps.com/opentaps");
	//step 3: Maximize the browser window.
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
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
	//step 8:click the account tab
	driver.findElement(By.linkText("Accounts")).click();
	//step 9:click create account buuton
	driver.findElement(By.linkText("Create Account")).click();
	//step 10:enter the accountname
	WebElement accountname = driver.findElement(By.id("accountName"));
	//step 11:enter valid accountname
	accountname.sendKeys("automation12345");
	//step 12:enter the description
	WebElement description = driver.findElement(By.name("description"));
	//step 13:enter valid description
	description.sendKeys("Selenium Automation Tester");
	//step 14:select the industry by selectByValue
	WebElement Industry=driver.findElement(By.name("industryEnumId"));
	Select option=new Select(Industry);
    option.selectByValue("IND_SOFTWARE");
    //step 15:select the ownership by selectByVisibleText
    WebElement OwnerShip=driver.findElement(By.name("ownershipEnumId"));
	Select option2=new Select(OwnerShip);
    option2.selectByVisibleText("S-Corporation");
    //step 16:Select the Source by selectByValue
    WebElement Source=driver.findElement(By.name("dataSourceId"));
   	Select option3=new Select(Source);
    option3.selectByValue("LEAD_EMPLOYEE");
    //step 17:Select the Marketingcampaign by selectByIndex
    WebElement Marketingcampaign =driver.findElement(By.name("marketingCampaignId"));
   	Select option5=new Select(Marketingcampaign);
    option5.selectByIndex(7);
    //step 18:select state by selectByValue
    WebElement State =driver.findElement(By.name("generalStateProvinceGeoId"));
   	Select option6=new Select(State);
    option6.selectByValue("TX");
    //step 19:click the create Account tab
    driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
    //step 20:verify the account name
    String a=driver.findElement(By.xpath("(//span[@class='tabletext'])[3]")).getText();
    System.out.println(a);
    if(a.contains("automation12345")) {
    	System.out.println("displayed");
    }
    else
    {
    	System.out.println("incorrect");
    
    //step 21:close the browser
    driver.close();
     
     
    
}
}
}