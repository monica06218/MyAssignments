package week3.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//step 1:Initialize the web driver
				ChromeOptions options=new ChromeOptions();
				options.addArguments("guest");
				ChromeDriver driver=new ChromeDriver();
				//step 2:load the url
				driver.get("https://www.leafground.com/alert.xhtml");
				//step 3:maximize the window and add implicit wait
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				//step 4:clcik the prompt alert
				driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
				//step 5:switch to alert and type a message
				org.openqa.selenium.Alert alert = driver.switchTo().alert();
				alert.sendKeys("Monica");
				//step 6:dismiss the alert
				alert.dismiss();
				//step 7:retrieve the result
				WebElement result=driver.findElement(By.xpath("//span[@id='confirm_result']"));
      			//step 8:verify the result
				String displayedText=result.getText();
				if(displayedText.contains("User cancelled the prompt.")) {
					System.out.println("Alert was dismissed");
				}
				else
				{
					System.out.println("unexpexted text is displayed");
				}
				
				
	}

}
