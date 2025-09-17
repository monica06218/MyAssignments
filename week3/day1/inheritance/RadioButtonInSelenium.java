package week3.day1.inheritance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class RadioButtonInSelenium {
    public static void main(String[] args) {
        // Setup WebDriver (Chrome)
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Load the URL
        driver.get("https://www.leafground.com/radio.xhtml");

        // === 1. Select 'Your most favourite browser' ===
        WebElement chromeRadio = driver.findElement(By.xpath("//label[text()='Chrome']/ancestor::div[contains(@class,'ui-radiobutton')]/div/input[@type='radio']"));
        chromeRadio.click();
        System.out.println("Selected 'Chrome' as favourite browser.");

        // === 2. Click same radio again (should stay selected if standard behavior) ===
        chromeRadio.click(); // Clicking again — radios don’t deselect on second click
        if (chromeRadio.isSelected()) {
            System.out.println("Chrome radio is still selected after second click (expected for radio buttons).");
        }

        // === 3. Identify default selected radio ===
        List<WebElement> defaultRadios = driver.findElements(By.xpath("//h5[text()='Find the default select radio button']/following::input[@type='radio']"));
        for (WebElement radio : defaultRadios) {
            if (radio.isSelected()) {
                WebElement label = radio.findElement(By.xpath("./following-sibling::label"));
                System.out.println("Default selected radio: " + label.getText());
                break;
            }
        }

        // === 4. Select age group (21-40 Years) if not already selected ===
        WebElement age21to40 = driver.findElement(By.xpath("//label[text()='21-40 Years']/preceding-sibling::div/input[@type='radio']"));
        if (!age21to40.isSelected()) {
            age21to40.click();
            System.out.println("Selected age group 21-40 Years.");
        } else {
            System.out.println("Age group 21-40 Years is already selected.");
        }

        // Done
       // driver.quit();
    }
}
