package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FacebookloginPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		// step 2 : load the url using .get() and maximize the window
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement Username=driver.findElement(By.id("email"));
		Username.sendKeys("testleaf.2023@gmail.com");
		WebElement Password=driver.findElement(By.id("pass"));
		Password.sendKeys("Tuna@321");
		WebElement Login=driver.findElement(By.name("login"));
		Login.click();
		driver.findElement(By.linkText("Find your account and log in.")).click();
		String title=driver.getTitle();
		System.out.println(title);
		String result=("Forgotten Password | Can't Log In | Facebook");
		if(title.equals(result)) {
			System.out.println("verified:"+title);
		}
	     
			driver.close();
	}

}
