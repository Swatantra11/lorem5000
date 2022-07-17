package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class CreateNewCampainsTest extends VtigerLoginTest {

	public void newCampain() {
		Actions a=  new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[text()='More']"))).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	}

	

}
