package week3.day1.inheritance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class InteractionswithCheckboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// step 1:Initialize the web driver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		// step 2:load the url
		driver.get("https://leafground.com/checkbox.xhtml");
		// step 3:maximize the window and add implicit wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// step 4:Click on the "Basic Checkbox"
		WebElement basicCheckbox = driver.findElement(By.xpath("//span[text()='Basic']"));
		basicCheckbox.click();

		// step 5: Click on the "Notification Checkbox"
		WebElement notificationCheckbox = driver.findElement(By.xpath("//span[text()='Ajax']"));
		notificationCheckbox.click();

		// step 6:Verify expected message is displayed (assuming message below
		// Notification checkbox)
		// wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement growlTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'ui-growl-message')]//span[@class='ui-growl-title']")));
		WebElement growlBody = driver.findElement(By.xpath("//div[contains(@class,'ui-growl-message')]//p"));

		System.out.println("✅ Ajax Notification:");
		System.out.println("Title: " + growlTitle.getText());
		System.out.println("Message: " + growlBody.getText());

		// step 7:Click on your favorite language checkbox (assuming it's "Java" here)
		WebElement javaCheckbox = driver.findElement(
				By.xpath("//label[text()='Java']/preceding-sibling::div//div[contains(@class,'ui-chkbox-box')]"));
		javaCheckbox.click();

		// step 8: Click on the "Tri-State Checkbox"
		WebElement triStateCheckbox = driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']"));
		triStateCheckbox.click();

		// step 9:Verify which tri-state option has been chosen

		By triStateMsgLocator = By.xpath("//*[contains(text(),'State')]");
		WebElement triStateValue = wait.until(ExpectedConditions.visibilityOfElementLocated(triStateMsgLocator));
		System.out.println("Tri-State checkbox selection message: " + triStateValue.getText());

		// step 10: Click on the "Toggle Switch"
		WebElement toggleSwitch = driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']"));
		toggleSwitch.click();

		// step 11: Verify that the expected message is displayed (assuming message
		// below Toggle Switch)
		boolean toggleMessage = driver.findElement(By.xpath("//input[@id='j_idt87:j_idt100_input']")).isSelected();
	    System.out.println("Toggle switch message: " + toggleMessage);

		// step 12: Verify if a specific Checkbox is disabled (assuming "Disabled"
		// checkbox label)
		WebElement disabledCheckbox = driver.findElement(By.xpath("//span[text()='Disabled']/preceding-sibling::div//input[@id='j_idt87:j_idt102_input']"));
		boolean isDisabled = !disabledCheckbox.isEnabled();
		System.out.println("Is 'Disabled' checkbox actually disabled? " + isDisabled);
		
	     
		driver.close();
	}

}
