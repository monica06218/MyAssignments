package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandling {
	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver=new ChromeDriver();
		//step 2:load the url
		driver.get("https://www.irctc.co.in/");
	  //step 3:maximize the window and add implicit wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//accept the popup
		 driver.findElement(By.xpath("//button[text()='OK']")).click();
	//step 4:Retrieve the window handler id of the current window
	    String parentWindow = driver.getWindowHandle();
	    System.out.println("parent Window handler id is "+ parentWindow);
        driver.findElement(By.linkText("FLIGHTS")).click();

		// step 5 : Get the id of all currently opened window
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Window handler id of currently opened window");
		for (String string : windowHandles) {
					System.out.println(string);
				}
		// step 2: convert set to list
		List<String> listOfWindowId = new ArrayList<String>(windowHandles);
			String childWindow = listOfWindowId.get(1);
				// step 3: retrieve the particular window id pass it as argument within window(_)
			driver.switchTo().window(childWindow);
			System.out.println(driver.getTitle());
				
				// NoSuchWindowException
				driver.switchTo().window(parentWindow);
				System.out.println(driver.getTitle()); 
				driver.close();
				

			}
		}

