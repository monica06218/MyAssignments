package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);// step 2 : load the url using .get() and maximize the window
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");
		
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("demosalesmanager");
		WebElement password = driver.findElement(By.name("PASSWORD"));
		password.sendKeys("crmsfa");
		WebElement Login=driver.findElement(By.className("decorativeSubmit"));
		Login.click();
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		WebElement Firstname = driver.findElement(By.name("firstNameLocal"));
		Firstname.sendKeys("Monica");
		WebElement Lastname = driver.findElement(By.name("lastNameLocal"));
		Lastname.sendKeys("Vijayaraghavan");
		WebElement Companyname = driver.findElement(By.className("inputBox"));
		Companyname.sendKeys("Testleaf");
		WebElement SourceDropdown=driver.findElement(By.name("dataSourceId"));
		Select option=new Select(SourceDropdown);
		option.selectByIndex(4);
		WebElement MarketingCampaign=driver.findElement(By.name("marketingCampaignId"));
		Select option1=new Select(MarketingCampaign);
		option1.selectByContainsVisibleText("Automobile");
		WebElement Ownership=driver.findElement(By.name("ownershipEnumId"));
		Select option2=new Select(Ownership);
		option2.selectByValue("OWN_CCORP");
		driver.findElement(By.linkText("Create Lead")).click();
		String title=driver.getTitle();
		System.out.println(title);
		String output=("Create Lead | opentaps CRM");
		if(title.equals(output)) {
			System.out.println("verified="+title);}
		}
		

	}


