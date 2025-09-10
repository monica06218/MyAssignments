package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class createaccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("guest");
				ChromeDriver driver = new ChromeDriver(options);// step 2 : load the url using .get() and maximize the window
				driver.manage().window().maximize();
				driver.get("http://leaftaps.com/opentaps");
				
				WebElement userName = driver.findElement(By.id("username"));
				userName.sendKeys("demosalesmanager");
				WebElement password = driver.findElement(By.name("PASSWORD"));
				password.sendKeys("crmsfa");
				WebElement Login=driver.findElement(By.className("decorativeSubmit"));
				Login.click();
				driver.findElement(By.partialLinkText("CRM")).click();
				driver.findElement(By.linkText("Accounts")).click();
				driver.findElement(By.linkText("Create Account")).click();
				WebElement accountname = driver.findElement(By.id("accountName"));
				accountname.sendKeys("tester");
				WebElement description = driver.findElement(By.name("description"));
				description.sendKeys("Selenium Automation Tester");
				WebElement employee = driver.findElement(By.id("numberEmployees"));
				employee.sendKeys("120");
				WebElement sitename = driver.findElement(By.id("officeSiteName"));
				sitename.sendKeys("LeafTaps");
				driver.findElement(By.linkText("Create Account")).click();
				String title=driver.getTitle();
				System.out.println(title);
				String output=("Create Account | opentaps CRM");
				if(title.equals(output)) {
					System.out.println("verified="+title);
				}
				driver.close();				
	}

}
