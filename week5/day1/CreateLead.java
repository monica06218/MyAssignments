package week5.day1;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

public class CreateLead extends ProjectSpecificMethods {
	@Test
	public void runCreateLead() throws InterruptedException {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Hari");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(2000);
		

	}

}
