package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// step 1:Initialize WebDriver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		// step 2: Load the URL
		driver.get("https://www.amazon.in/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// step 3:Scroll down to the "Conditions of Use and Sale" section at the bottom
		// of the page using Actions class.

		WebElement conditionsLink = driver.findElement(By.linkText("Conditions of Use & Sale"));
		 Actions actions = new Actions(driver);
	        actions.scrollToElement(conditionsLink).perform();
	        Thread.sleep(1000); 
	        
	        // step 4: Get and print the text of the link
	        String linkText = conditionsLink.getText();
	        System.out.println("Text of the link: " + linkText);

	}

}
