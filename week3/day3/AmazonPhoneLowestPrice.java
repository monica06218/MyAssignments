package week3.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonPhoneLowestPrice {

    public static void main(String[] args) throws InterruptedException {
        // Optional: Set path to ChromeDriver manually if not in system PATH
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Navigate to Amazon India
        driver.get("https://www.amazon.in");
        try {
            Thread.sleep(3000); // Small wait for popup to appear
            WebElement continueBtn = driver.findElement(By.xpath("//button[@type='submit']"));
            continueBtn.click(); // ✅ Using .click() here
            System.out.println("Clicked 'Continue to Amazon.in'");
            Thread.sleep(3000); // Wait after clicking
        } catch (Exception e) {
            System.out.println("No 'Continue' button found — skipping.");
        }

        // 2. Search for "phones"
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("phones");
        //searchBox.submit();
        driver.findElement(By.xpath("id.nav-search-submit-button")).click();

        // 3. Wait for search results to load
        Thread.sleep(5000); // Consider replacing with WebDriverWait in production

        // 4. Get all visible prices
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='a-price-whole']']"));
        System.out.println(priceElements);

        List<Integer> prices = new ArrayList<>();
        
        for(WebElement webElement:priceElements) {
        	String pricetext=webElement.getText().replace(",", "").trim();
        	
        int price = Integer.parseInt(pricetext);
        prices.add(price);
        }
        Collections.sort(prices);
        int lowest = prices.get(0);
        System.out.println("📱 Lowest phone price: ₹" + lowest);
    }
    
}
      

