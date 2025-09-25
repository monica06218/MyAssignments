package week3.day1.inheritance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class RadioButtonInSelenium {
	public static void main(String[] args) {
		// Setup WebDriver (Chrome)
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Load the URL
		driver.get("https://www.leafground.com/radio.xhtml");

		// Step 1. Select 'Your most favourite browser'
		WebElement favourite = driver.findElement(
				By.xpath("//h5[text()='Your most favorite browser']//following::label[text()='Chrome'][1]"));
		favourite.click();
		// step 2:then click on the same radio button again to verify that it becomes
		// ‘unselected’.

		if (favourite.isSelected()) {
			System.out.println(" Radio button became unselected after second click.");
		} else {
			System.out.println(" Radio button remains selected after second click.");
		}
		// step 3: Check which radio button is selected by default
		WebElement labels = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']"));
		System.out.println("Default selected radio button: " + labels.getText());

		// step 4:Check and select the age group (21-40 Years) if not already selected
		WebElement ageRadio = driver.findElement(By.xpath("//label[text()='21-40 Years']"));
		if (!ageRadio.isSelected()) {
			ageRadio.click();
			System.out.println("21-40 Years' was not selected. Now selected.");
		} else {
			System.out.println("21-40 Years' is already selected.");
		}
	}
}
