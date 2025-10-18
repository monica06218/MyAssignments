package week4.day2;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTable {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Initialize ChromeDriver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://erail.in/");

		// Maximize the browser window
		driver.manage().window().maximize();

		// Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter "MAS" in from station
		WebElement fromstation = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		fromstation.clear();
		fromstation.sendKeys("MAS");
		fromstation.sendKeys("\n");// press enter to accept
		Thread.sleep(2000);

		// Enter "MDU" in To Station

		WebElement Tostation = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		Tostation.clear();
		Tostation.sendKeys("MDU");
		Tostation.sendKeys("\n");// press enter to accept
		Thread.sleep(2000);

		// Unchect sort on date
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();

		// retrieve the train names from the web table
		WebElement table = driver.findElement(By.xpath("//div[@id='divTrainsList']"));
		List<WebElement> tnames = (List<WebElement>)table.findElement(By.xpath("//div[@id='divTranisList]//tr/td[2]"));
		System.out.println(tnames);
		Set<String> uniquenames = new HashSet<>();
		boolean duplicate = false;
		for (WebElement names : tnames) {
			String tnames1 = names.getText().trim();
			System.out.println(tnames1);

			if (!uniquenames.add(tnames1)) {
				System.out.println("duplicate" + tnames1);
				duplicate = true;
			}

		}

		if (duplicate) {
			System.out.println("duplicte found");
		}

		else {
			System.out.println("not duplicate");
		}

	}
}
