package week5.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Salesforce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--guest"); 
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		// load the URL
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("vinitharaghavan123855@agentforce.com");
		driver.findElement(By.id("password")).sendKeys("Sidhunirashiv@0619");
		driver.findElement(By.name("Login")).click();
          //clcik toggle menu
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		//click view all
	//	driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement search=driver.findElement(By.xpath("//input[@part='input']"));
		search.sendKeys("Legal Entities");
		//search.submit();
		
		//click legal Entities
		driver.findElement(By.xpath("//b[text()='Legal Entities']")).click();
		//driver.findElement(By.xpath("//button[text()='Dismiss']")).click();
		
		//click new legal entity
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		//enter the company name
		WebElement company=driver.findElement(By.xpath("//input[@name='CompanyName']"));
		company.sendKeys("Testleaf");
		
		//enter the description
		WebElement description=driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
		description.sendKeys("Salesforces");
		
		//select the status as active
		driver.findElement(By.xpath("//button[@data-value='Active']")).click();
		
		//click save button
		driver.findElement(By.name("SaveEdit")).click();
		
		//verify the alert message
		driver.findElement(By.xpath("//div[text()='Complete this field.']"));
		//switch to alert
		Alert alert=driver.switchTo().alert();
		//get the alert text
		String message=alert.getText();
		System.out.println(message);
		
		String expectedmessage="Complete this field.";
		if(message == expectedmessage) {
			System.out.println("alert is verified");
		}
		else
		{
			System.out.println("not verified");
		}
		
		}
}