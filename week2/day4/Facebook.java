package week2.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) {
		// step 1:Initialize the WebDriver (ChromeDriver).
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		// step 2 : load the url using .get() and maximize the window
		driver.get("https://www.facebook.com/");
		// step 3: Maximize the browser window.
		driver.manage().window().maximize();
		// step 4:- Add an implicit wait to ensure the web page elements are fully
		// loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		// step 5:click on create a new account
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		// step 6:enter first name
		WebElement firstname = driver.findElement(By.name("firstname"));
		// step 7:valid the firstname
		firstname.sendKeys("Monica");
		// step 7:enter last name
		WebElement Surname = driver.findElement(By.name("lastname"));
		// step 8:valid the Surname
		Surname.sendKeys("Vijayaraghavan");
		// step 9:enter mobile number
		WebElement mobilenumber = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		// step 10:valid the mobilenumber
		mobilenumber.sendKeys("1234567896");
		// step 11:Enter the new password
		WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		// step 12:valid the password
		Password.sendKeys("Moni@321");
		// step 13:select the date
		WebElement date = driver.findElement(By.name("birthday_day"));
		Select option = new Select(date);
		option.selectByValue("3");
		// step 14:select the month
		WebElement month = driver.findElement(By.name("birthday_month"));
		Select option2 = new Select(month);
		option2.selectByValue("11");
		// step 15:select the year
		WebElement year = driver.findElement(By.name("birthday_year"));
		Select option3 = new Select(year);
		option3.selectByValue("1999");
		//step 16:select gender
		driver.findElement(By.xpath("//input[@value=\"1\"]")).click();
		

	}

}
