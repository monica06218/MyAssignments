package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SnapdealAutomation {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//Initialize ChromeDriver
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		
		// Load the URL (https://www.snapdeal.com/)
		driver.get("https://www.snapdeal.com");
		
		// Maximize the browser window
		driver.manage().window().maximize();
		
		// Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//go to Men's Fashion".
		driver.findElement(By.xpath("(//span[@class='catText'])[1]")).click();
		
		//go to "SportsShoes"
	   WebElement sportsShoes= driver.findElement(By.linkText("Sports Shoes"));
	   Actions actions = new Actions(driver);
	   actions.moveToElement(sportsShoes).click().perform();
	   
	   //get the no of items
	   String count=driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
	   System.out.println(count);
	   
	   //click on "Training Shoes"
	   driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
	   
	   //sort by low to high
	   driver.findElement(By.xpath("//span[@data-action='a-dropdown-button']")).click();
		driver.findElement(By.xpath("//a[@class='a-dropdown-link']")).click();
	   //Check if the displayed items are sorted correctly.
	   
		WebElement firstPriceElement = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String firstPdtPrice = firstPriceElement.getText().replaceAll(",", "");
		Thread.sleep(1000);

		WebElement secondPriceElement = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[2]"));
		String secondPdtPrice = secondPriceElement.getText().replaceAll(",", "");
		Thread.sleep(1000);

		int price1 = Integer.parseInt(firstPdtPrice);
		System.out.println("First pdt price =" + price1);
		int price2 = Integer.parseInt(secondPdtPrice);
		System.out.println("Second pdt price =" + price2);

		if (price1 < price2) {
			System.out.println("The displayed result is sorted from low to high as expected");
		} else {
			System.out.println("The displayed result is not as expected");
		}

//Select any price range ex:(500-700).- //doubt in this place- not able to chose and get the right price range but is working
		WebElement priceRange = driver.findElement(By.xpath("(//ul[@aria-labelledby='p_36-title']//li)[2]"));
		priceRange.click();
		String price = priceRange.getText();
		System.out.println("The displayed Price Range for Nike Shoes are = " + price);

//Filter by any colour. - I chose "white color"
		driver.findElement(By.xpath("(//div[@class='colorsprite aok-float-left'])[3]")).click();
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window handler id is "+ parentWindow);
//Verify all the applied filters.//couldnt do as the range is not right
//Mouse hover on the first resulting "Training Shoes" and Click the "Quick View" button. ie click the shoe image
		actions.moveToElement(driver.findElement(By.xpath("(//div[@data-component-type='s-search-result'])[2]//img"))).click().perform();
		Thread.sleep(1000);
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Window handler id of currently opened window: " + windowHandles);
//convert set to list
		List<String> listOfWindowId = new ArrayList<String>(windowHandles);
		String childWindow = listOfWindowId.get(1);
// retrieve the particular window id pass it as argument within window(_)
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());	
		
// Print the cost and the discount percentage.
		//String title = driver.findElement(By.xpath("//h1[@id='title']/span")).getText();//doubt
		
		WebElement costItem = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[2]"));
		String cost = costItem.getText();
		 //span[text()='-54%']
		WebElement disPercent = driver.findElement(By.xpath("//span[contains(text(),'%')]"));
		String discountPercentage = disPercent.getText();
		System.out.println("Cost of Mens Nike Training Shoes is = " + cost + " with discount% as "  +  discountPercentage);
		
//Take a snapshot of the shoes.
		//Step 1 : stored the temporary file as a local variable
		File src = driver.getScreenshotAs(OutputType.FILE);
		// Step 2 : we have created the folder and file name along with the file format 
		File target = new File("./image/Nikecart.png");
		// step 3 : transfer the data from the temp to physical file
		FileUtils.copyFile(src, target);	
//Close  Browsers		
			driver.close(); // closes child window
			driver.switchTo().window(parentWindow);
			driver.close(); // closes parent

	   
}
}