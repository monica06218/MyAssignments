package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WindowHandlingAssignmnet {

	public static void main(String[] args) throws InterruptedException
	{
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
		 // 3. Click CRM/SFA link
        driver.findElement(By.linkText("CRM/SFA")).click();

        // 4. Click Contacts
        driver.findElement(By.linkText("Contacts")).click();

        // 5. Click Merge Contacts
        driver.findElement(By.linkText("Merge Contacts")).click();

        // Store the main window handle
        String mainWindowHandle = driver.getWindowHandle();
        
        // 6. Click the widget of "From Contact" to open new window
        driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
        
        // Switch to new window for "From Contact"
        switchToNewWindow(driver, mainWindowHandle);
     // 7. Click on the first resulting contact
        Thread.sleep(2000); // wait for results to load
        driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();

        // Switch back to main window
        driver.switchTo().window(mainWindowHandle);

        // 8. Click the widget of "To Contact" to open new window
        driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();

        // Switch to new window for "To Contact"
        switchToNewWindow(driver, mainWindowHandle);

        // 9. Click on the second resulting contact
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();

        // Switch back to main window
        driver.switchTo().window(mainWindowHandle);

        // 10. Click Merge button
        driver.findElement(By.xpath("//a[text()='Merge']")).click();

        // 11. Accept the alert
        
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // 12. Verify the title of the page
        String expectedTitle = "Merge Contacts | opentaps CRM";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification passed.");
        } else {
            System.out.println("Title verification failed.");
           
        }

      driver.quit();
	}
        private static void switchToNewWindow(WebDriver driver, String mainWindowHandle) {
            Set<String> allWindowHandles = driver.getWindowHandles();
            for (String handle : allWindowHandles) {
                if (!handle.equals(mainWindowHandle)) {
                    driver.switchTo().window(handle);
                    break;
                }

	}}
}