package com.crm.reqing.contactTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.crm.reqing.loginTest.LoginTest;

public class CreateDeleteContacTest extends LoginTest {

	public void deletecontact() {
		CreateContactTest c= new CreateContactTest();
		String name= c.lastname;
		System.out.println("contact deleting started ");
		
		driver.findElement(By.name("Delete")).click();

		Alert a =driver.switchTo().alert();
		a.accept();

		driver.findElement(By.className("txtBox")).sendKeys(name);

		WebElement searchfield = driver.findElement(By.id("bas_searchfield"));
		Select s= new Select(searchfield);
		s.selectByIndex(2);
		driver.findElement(By.name("submit")).click();
		String text = driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).getText();
		
		if(text.contains("No Contact Found")) {
			System.out.println(" contact deleted succesfully");
		}
		else {
			System.out.println(" contact not deleted");
		}
	}
	public void finaldelete() {
		
		System.out.println(" contact all delete started ");
		driver.findElement(By.linkText("Contacts")).click();
	}
}
