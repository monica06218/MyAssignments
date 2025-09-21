package week3.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Frame {
	public static void main(String[] args) {

		// Set the path to chromedriver if it's not in your system PATH
		// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		// Initialize ChromeDriver
		WebDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");

		// Maximize the browser window
		driver.manage().window().maximize();

		// Add an implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Switch to the iframe
		driver.switchTo().frame("iframeResult");

		// Click the "Try it" button
		WebElement tryItButton = driver.findElement(By.xpath("//button[text()='Try it']"));
		tryItButton.click();

		// Handle the alert (Click OK or Cancel)
		driver.switchTo().alert().accept(); // Use .dismiss() to click Cancel

		// Verify the result text
		WebElement resultText = driver.findElement(By.id("demo"));
		String actualText = resultText.getText();

		// Print the result to console
		System.out.println("Displayed Text: " + actualText);

		// verification
		if (actualText.contains("OK")) {
			System.out.println("Alert accepted successfully.");
		} else if (actualText.contains("Cancel")) {
			System.out.println("Alert dismissed successfully.");
		} else {
			System.out.println("Unexpected result text.");
		}

		driver.quit();

	}
}
