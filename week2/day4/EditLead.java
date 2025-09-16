package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// step 1:Initialize the WebDriver (ChromeDriver).
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		// step 2 : load the url using .get() and maximize the window
		driver.get("http://leaftaps.com/opentaps");
		// step 3: Maximize the browser window.
		driver.manage().window().maximize();
		// step 4:locate the username field
		WebElement userName = driver.findElement(By.id("username"));
		// step 5:Enter the valid username
		userName.sendKeys("demosalesmanager");
		// step 6:enter the password
		WebElement password = driver.findElement(By.name("PASSWORD"));
		// step 7:enter valid password
		password.sendKeys("crmsfa");
		// step 6:click the login button
		WebElement Login = driver.findElement(By.className("decorativeSubmit"));
		Login.click();
		// step 7:click the link tag i.e CRM
		driver.findElement(By.partialLinkText("CRM")).click();
		// step 8:click the leads link
		driver.findElement(By.linkText("Leads")).click();
		// step 9:click the create lead button
		driver.findElement(By.linkText("Create Lead")).click();
		// step 10:enter the company name using xpath
		WebElement companyname = driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']"));
		// step 11:enter valid companyname
		companyname.sendKeys("xxx");
		// step 12:enter the firstname
		WebElement forename = driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']"));
		// step 13:enter valid forename
		forename.sendKeys("Monica");
		WebElement surname = driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']"));
		// step 13:enter valid surname
		surname.sendKeys("Vijayaraghavan");
		// step 14:enter the firstnamelocal
		WebElement firstnamelocal = driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']"));
		// step 15:valid the firstnamelocal
		firstnamelocal.sendKeys("ccc");
		// step 16:enter the department name
		WebElement departmentname = driver.findElement(By.name("departmentName"));
		// step 17:valid the department name
		departmentname.sendKeys("testing");
		// step 16:enter the description field
		WebElement description = driver.findElement(By.name("description"));
		// step 17:valid the description name
		description.sendKeys("software testing");
		// step 18:enter the email
		WebElement email = driver.findElement(By.id("createLeadForm_primaryEmail"));
		// step 19:valid the email
		email.sendKeys("xxx@gmail.com");
		// step 20:Select the state
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select option = new Select(state);
		option.selectByContainsVisibleText("New York");
		// step 21:click the create button
		driver.findElement(By.name("submitButton")).click();
		//step 22:click edit button
		driver.findElement(By.linkText("Edit")).click();
		// step 23:clear the description field
		driver.findElement(By.name("description")).clear();
		//step 24:fill the important note
		WebElement importantnote=driver.findElement(By.id("updateLeadForm_importantNote"));
		//step 25:valid the importantnote
		importantnote.sendKeys("testing phase");
		//step 26:click on update button
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(2000);
		String t=driver.getTitle();
		System.out.println("current title page"+t);
		


	}

}
