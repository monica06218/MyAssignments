package week4.day2;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ActionClassAmazonAutomation {

    public static void main(String[] args) throws IOException {

        // Setup ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Initialize Actions class
        Actions actions = new Actions(driver);

        // 1. Load Amazon.in
        driver.get("https://www.amazon.in/");

        // 2. Search for "oneplus 9 pro"
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.moveToElement(searchBox).click().sendKeys("oneplus 9 pro").perform();
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        actions.moveToElement(searchButton).click().perform();

        // 3. Get the price of the first product
        WebElement firstPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[4]"));
        String priceText = firstPrice.getText();
        System.out.println("Price of the first product: ₹" + priceText);

        // 4. Get customer ratings for the first product
        WebElement ratingElement = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
        String ratingText = ratingElement.getText();
        System.out.println("Customer Ratings: " + ratingText);

        // 5. Click the first text link of the first image
        WebElement firstProductLink = driver.findElement(By.className("s-image"));
        actions.moveToElement(firstProductLink).click().perform();

        // 6. Switch to new tab/window
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
        }

        // 7. Take a screenshot of the product page
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File folder = new File("./Amazon");
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File targetFile = new File(folder, "product.png");
		FileUtils.copyFile(screenshot, targetFile);
		System.out.println("Screenshot saved at: " + targetFile.getAbsolutePath());

        // 8. Click the 'Add to Cart' button using Actions class
       
        WebElement cart = driver.findElement(By.id("add-to-cart-button"));
        cart.click();
        

        // 9. Wait for subtotal and verify it
        WebElement subtotalElement = driver.findElement(By.xpath("span[@class='a-price-whole'])[1"));
        String subtotalText = subtotalElement.getText();
        System.out.println("Cart Subtotal: " + subtotalText);

        // Verify subtotal
        String numericSubtotal = subtotalText.replaceAll("[^0-9]", "");
        String numericPrice = priceText.replaceAll("[^0-9]", "");
        if (numericSubtotal.equals(numericPrice)) {
            System.out.println("Subtotal matches the product price.");
        } else {
            System.out.println("Subtotal does NOT match the product price.");
        }

        // 10. Close browser
        driver.quit();
    }
}
