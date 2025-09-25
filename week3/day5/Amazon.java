package week3.day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;

public class Amazon{
	
public static void main(String[] args) {
	
	//step 1:initialze the web driver
	ChromeOptions options = new ChromeOptions();
    options.addArguments("guest");
    WebDriver driver = new ChromeDriver(options);
    //step 2:launch browser and maximize
	driver.manage().window().maximize();
	//step 3:load the url
	driver.get("https://www.amazon.in/");
	 //step 4:launch the browser and add implicit wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//step 5:click continue button
	driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
	//step 6:search for bags for boys in search bar
	WebElement s=driver.findElement(By.id("twotabsearchtextbox"));
	s.sendKeys("Bags for boys");
	s.submit();
	//step 7:. Get and print total number of results
    WebElement resultText = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
    System.out.println("Results: " + resultText.getText());
    //step 8:select the first two brands   menu
    driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[5]")).click();
    driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[6]")).click();

      //step 9:choose new Arrivals (sort)
    driver.findElement(By.xpath("//span[@class='a-dropdown-label']")).click();
    driver.findElement(By.xpath("(//a[@class='a-dropdown-link'])[4]")).click();
    
    //step 10:name of price of resulting bag
   String name= driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base'])[1]")).getText();
   System.out.println(name);
  String price=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
  System.out.println(price);
  String t=driver.getTitle();
  System.out.println(t);
}
}