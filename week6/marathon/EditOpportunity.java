package week6.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EditOpportunity extends ProjectSpecificMethods {
	@Test
	public void edit() throws InterruptedException {

		// "Test Steps:
		// 1. Login to https://login.salesforce.com
		// 2. Click on toggle menu button from the left corner
		// 3. Click view All and click Sales from App Launcher
		// 4. Click on Opportunity tab
		// 5. Search the Opportunity 'Salesforce Automation by *Your Name*'
		// 6. Click on the Dropdown icon and Select Edit
		// 7. Choose close date as Tomorrow date
		// 8. Select 'Stage' as Perception Analysis
		// 9. Select Deliver Status as In Progress
		// 10. Enter Description as SalesForce
		// 11. Click on Save and Verify Stage as Perception Analysis
		// "

		// Open Browser

		// Click on toggle menu button
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// Click view All
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		// Click Sales from App Launcher
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		// Click on Opportunity tab
		WebElement opportunities = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
		driver.executeScript("arguments[0].click();", opportunities);
		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[contains(@class,'test-listviewdisplayswitcher')]")).click();
		driver.findElement(By.xpath("//li[@title='Kanban']")).click();

		// 5. Search the Opportunity 'Salesforce Automation by *Your Name*'
		WebElement oppName = driver.findElement(By.xpath("//label[text()='Search this list...']//following::input[1]"));
		oppName.sendKeys("Monica");
		Thread.sleep(2000);
		oppName.sendKeys(Keys.ENTER);

		// ,Keys.ENTER);

		// 6. Click on the Dropdown icon and Select Edit
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='showActionsButtonContainer'])[1]")).click();

		WebElement edit = driver.findElement(By.xpath("(//div[text()='Edit'])[1]"));
		driver.executeScript("arguments[0].click();", edit);

		Thread.sleep(3000);
		WebElement element = driver.findElement(
				By.xpath("(//button[contains(@class,'slds-button trigger slds-button_icon-border')])[4]//span[2]"));
		driver.executeScript("arguments[0].click();", element);

		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//table[@class='slds-datepicker__month']//tr[2]/td[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@role='combobox']//span)[2]")).click();
		driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();

		Thread.sleep(3000);

		WebElement status = driver.findElement(By.xpath("//a[text()='Delivery Status']"));

		Actions delivery = new Actions(driver);
		delivery.scrollToElement(status).perform();

		driver.findElement(By.xpath("(//button[@role='combobox']//span)[4]")).click();

		driver.findElement(By.xpath("(//span[text()='In progress'])[1]")).click();

		Thread.sleep(3000);
		driver.executeScript("document.body.style.zoom='80%'", "");
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("Salesforce");

		driver.findElement(By.xpath("//button[text()='Save']")).click();

		WebElement verify = driver.findElement(By.xpath("(//span[text()='Perception Analysis'])[3]"));

		System.out.println(verify.getText());

	}

}
