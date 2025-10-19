package week4.marathon;

// Marathon - Tatacliq********

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
import org.openqa.selenium.support.ui.Select;

public class Tatacliq {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Setup Chrome in guest mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Load URL
		driver.get("https://www.tatacliq.com/");

		// Close initial pop-up
		driver.findElement(By.id("moe-dontallow_button")).click();

		// Mouse hover: Brands -> Watches & Accessories -> Casio
		Actions act = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//div[text()='Brands']"));
		act.moveToElement(brands).perform();

		WebElement watches = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		act.moveToElement(watches).perform();

		WebElement casio = driver.findElement(By.xpath("//div[text()='Casio']"));
		casio.click();

		// Sort by New Arrivals
		WebElement dropOptions = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		new Select(dropOptions).selectByVisibleText("New Arrivals");

		Thread.sleep(3000);

		// Choose Category: Men
		driver.findElement(By.xpath("//div[text()='Men']")).click();
		Thread.sleep(3000);

		// Print all prices of watches
		List<WebElement> phoneCosts = driver.findElements(
				By.xpath("//div[contains(@class, 'ProductDescription__priceHolder')]//h3"));
		List<Integer> prices = new ArrayList<>();
		for (WebElement el : phoneCosts) {
			String priceText = el.getText().replaceAll("[^0-9]", "");
			if (!priceText.isEmpty()) {
				prices.add(Integer.parseInt(priceText));
			}
		}
		System.out.println("List of Watch Prices = " + prices);

		// Store parent window handle
		String parentWindow = driver.getWindowHandle();

		// Click on first product
		WebElement firstProduct = driver
				.findElement(By.xpath("(//div[@class='ProductModule__dummyDiv'])[1]"));
		firstProduct.click();

		Thread.sleep(3000);

		// Switch to new tab
		Set<String> Windows = driver.getWindowHandles();
		for (String each : Windows) {
			if (!each.equals(parentWindow)) {
				driver.switchTo().window(each);
				break;
			}
		}

		// Get price on product detail page
		String childPrice = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3"))
				.getText().replaceAll("[^0-9]", "");
		System.out.println("Cost in  Child Window = " + childPrice);

		// Switch back to parent to get price there
		driver.switchTo().window(parentWindow);
		String parentPrice = driver.findElement(
				By.xpath("(//div[contains(@class, 'ProductDescription__priceHolder')]//h3)[1]"))
				.getText().replaceAll("[^0-9]", "");
		System.out.println("Cost in Parent Window = " + parentPrice);

		if (childPrice.equals(parentPrice)) {
			System.out.println("Price is same in both windows.");
		} else {
			System.out.println("Price mismatch!");
		}

		// Switch back to child window
		for (String each : driver.getWindowHandles()) {
			if (!each.equals(parentWindow)) {
				driver.switchTo().window(each);
				break;
			}
		}

		// Add to cart
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		Thread.sleep(2000);

		// Get cart count
		String cartCount = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();

		// Go to cart
		driver.findElement(By.xpath("//div[contains(@aria-label,'Go to Cart')]")).click();
		Thread.sleep(3000);

		// Verify item presence in cart
		String itemInCart = driver
				.findElement(By.xpath("(//span[@class='SizeQuantitySelectBox__text'])[2]")).getText();
		if (cartCount.equals(itemInCart)) {
			System.out.println("Item successfully added to cart.");
		} else {
			System.out.println("Item not found in cart.");
		}

		// Take screenshot
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File folder = new File("./Casio");
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File targetFile = new File(folder, "cart.png");
		FileUtils.copyFile(screenshot, targetFile);
		System.out.println("Screenshot saved at: " + targetFile.getAbsolutePath());

		// Close all windows
		driver.quit();
	}
}
