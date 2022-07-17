package com.crm.reqing.CamapinsTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.reqing.loginTest.LoginTest;

public class CreateAndDeleteCampaignTest extends LoginTest {
	public void deletecampiagn(){
		CreateCampainsTest c=new CreateCampainsTest();
		String name=c.campname;
		System.out.println(" Campaign deleting stared");
		driver.findElement(By.name("Delete")).click();

		Alert a =driver.switchTo().alert();
		a.accept();
        
		driver.findElement(By.name("search_text")).sendKeys(name);

		WebElement searchfield = driver.findElement(By.id("bas_searchfield"));
		Select s= new Select(searchfield);
		s.selectByIndex(1);
		driver.findElement(By.name("submit")).click();
		String text = driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).getText();
		
		if(text.contains("No Campaign Found")) {
			System.out.println(" Campaign deleted succesfully");
		}
		else {
			System.out.println(" Campaign not deleted");
		}

	}
	
	public void finaldelete() {
		
		System.out.println(" campaign all delete started ");
	
		Actions a=  new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[text()='More']"))).perform();
		driver.findElement(By.linkText("Campaigns")).click();
	}
}
