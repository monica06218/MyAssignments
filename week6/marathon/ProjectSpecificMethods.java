package week6.marathon;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class ProjectSpecificMethods {
	//declaring driver as Global variable
	public ChromeDriver driver;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preconditions(String url,String userName,String password) {
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications");
		options.addArguments("guest");
		//Initializing the driver instances
		 driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='Login']")).click();

	}
		@AfterMethod
		public void postconditions() {
			driver.close();
			
		
		
	}
	

}
