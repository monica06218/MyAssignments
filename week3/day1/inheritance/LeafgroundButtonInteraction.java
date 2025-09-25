package week3.day1.inheritance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;

public class LeafgroundButtonInteraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//step 1:Initialize the web driver
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver=new ChromeDriver();
		//step 2:load the url
		driver.get("https://leafground.com/button.xhtml");
		//step 3:maximize the window and add implicit wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 //step 4:Click on button with text 'Click and Confirm title.'
        WebElement clickAndConfirm = driver.findElement(By.xpath("//span[text()='Click']"));
        clickAndConfirm.click();
        //verify the title:dashboard
        String title=driver.getTitle();
        System.out.println("the titel is:"+title);
        String result="dashboard";
        if(title.equalsIgnoreCase(result)) {
        	System.out.println("matched");
        }
        else
        {
        	System.out.println("not matched");
        }
        //navigate
        driver.navigate().back();
        // step 5:Check if 'Confirm if the button is disabled' is disabled
        WebElement confirmDisabledBtn = driver.findElement(By.xpath("//span[text()='Disabled']/parent::button"));
        boolean isDisabled = !confirmDisabledBtn.isEnabled();
        System.out.println("'Confirm if the button is disabled' button disabled? " + isDisabled);
        //step 6: Find and print position of button with text 'Submit'
        WebElement submitBtn = driver.findElement(By.xpath("//span[text()='Submit']/parent::button"));
        Point position = submitBtn.getLocation();
        System.out.println("Submit button position: x = " + position.getX() + ", y = " + position.getY());

        // step 7: Find and print background color of button with text 'Find the Save button color.'
        WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']/parent::button"));
        String bgColor = saveBtn.getCssValue("background-color");
        System.out.println("Save button background color: " + bgColor);

        // step 8: Find and print height and width of button with text 'Find the height and width of this button.'
        WebElement sizeBtn = driver.findElement(By.xpath("(//span[text()='Submit']/parent::button)[2]"));
        Dimension size = sizeBtn.getSize();
        System.out.println("Button height: " + size.getHeight() + ", width: " + size.getWidth());



	}

}
