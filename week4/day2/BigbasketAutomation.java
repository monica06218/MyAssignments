package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class BigbasketAutomation {
  public static void main(String[] args) throws InterruptedException, IOException {
	  // Setup ChromeDriver
      ChromeOptions options = new ChromeOptions();
      options.addArguments("guest");
      WebDriver driver = new ChromeDriver(options);

      // Implicit wait
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      driver.manage().window().maximize();

      // Initialize Actions class
      Actions actions = new Actions(driver);

      // 1. Load url
      driver.get("https://www.bigbasket.com/");
      driver.navigate().refresh();   
      
      // 2. click shop and category
      WebElement shop= driver.findElement(By.xpath("(//span[text()='Shop by']/following-sibling::span[text()='Category'])[2]"));
      actions.moveToElement(shop).click().perform();
      //mouse over to Foodgrains,Oil&Masala
      WebElement food= driver.findElement(By.xpath("//a[text()='Foodgrains, Oil & Masala']"));
      actions.moveToElement(food).click().perform();
      //mouse over Rice&Rice Products
      WebElement Rice=driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
      actions.moveToElement(Rice).click().perform();
      //click on Boil&Steamed Rice
      driver.findElement(By.xpath("(//a[text()='Boiled & Steam Rice'])[2]")).click();
      //select bb Royal
      driver.findElement(By.xpath("//input[@id='i-bbRoyal']")).click();
      //select Tamil Ponni Boiled Rice & select 5kg ponni boiled rice
      driver.findElement(By.xpath("//h3[text()=''Tamil Ponni Boiled Rice]")).click();
      driver.findElement(By.xpath("//div[text()='5 kg - (12-17 Months Old)']")).click();

    
      //check and note the price
      String price=driver.findElement(By.xpath("//span[text()='₹₹346]")).getText();
      System.out.println(price);
      //add to cart
      driver.findElement(By.xpath("(//button[text()='Add'])[12]")).click();
      
      //verify the message
    String msg=driver.findElement(By.xpath("//p[text()='An item has been added to your basket successfully']")).getText() ;
     System.out.println(msg);
     String expectedmsg="An item has been added to your basket successfully";
     if(msg==expectedmsg) {
    	 System.out.println("verified");
     }
      else
      {
    	  System.out.println("not verified");
      }
      // Take a screenshot of the product page
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File folder = new File("./Amazon");
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File targetFile = new File(folder, "product.png");
		FileUtils.copyFile(screenshot, targetFile);
		System.out.println("Screenshot saved at: " + targetFile.getAbsolutePath());
      
      
      //close the window
		driver.close();
      
      
	  
  }
}
