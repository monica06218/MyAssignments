package week3.day5;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class BookMovieTickets {
	public static void main(String[] args) throws InterruptedException {

		// Set Chrome preferences to block notifications
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.notifications", 2); // 2 = block

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-popup-blocking");
		// options.addArguments("--guest"); // ⚠️ Remove if not required

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		// load the URL
		driver.get("https://www.pvrcinemas.com/");

		// 3) Choose Location - Chennai (if not auto-detected)
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[text()='Chennai']"))).click();

		// 4) Click 'Cinema' under Quick Book
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Cinema']"))).click();

		// 5) Select a Cinema (first one)
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='INOX The Marina Mall, OMR, Chennai']"))).click();

		// 6) Select date as tomorrow
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'day-box')])[2]"))).click();

		// 7) Select a movie (first one)
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='movie-box'])[1]"))).click();

		// 8) Select show time (first one)
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='showtime-pill'])[1]"))).click();

		// 9) Click Book button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Book')]"))).click();

		// 10) Accept Terms and Conditions
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Accept')]"))).click();

		// 11) Click one available seat
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(@class,'seat') and not(contains(@class,'unavailable'))]"))).click();

		// 12) Click Proceed
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Proceed')]"))).click();

		// 13) Print Seat Info
		WebElement seatInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//div[contains(@class,'book-summary')]//div[contains(text(),'Seat')]/following-sibling::div")));
		System.out.println("Seat Info: " + seatInfo.getText());

		// 14) Print Grand Total
		WebElement total = driver.findElement(By.xpath("//div[contains(text(),'Grand Total')]/following-sibling::div"));
		System.out.println("Grand Total: " + total.getText());

		// 15) Click Proceed & Continue
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Proceed & Continue')]")))
				.click();

		// 16) Close popup (if appears)
		WebElement closePopup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Close')]")));
		closePopup.click();

		// 17) Print Page Title
		System.out.println("Page Title: " + driver.getTitle());

		// 18) Close Browser
		driver.quit();
	}
}
