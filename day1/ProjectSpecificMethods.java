package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecificMethods {
	//declaring driver as Global variable
	ChromeDriver driver;
	@BeforeMethod
	public void preconditions() {
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications");
		options.addArguments("guest");
		//Initializing the driver instances
		 driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
		@AfterMethod
		public void postconditions() {
			driver.close();
			
		
		
	}
	

}
