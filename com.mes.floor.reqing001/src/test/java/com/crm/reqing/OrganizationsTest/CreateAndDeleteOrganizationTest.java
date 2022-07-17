package com.crm.reqing.OrganizationsTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.crm.reqing.contactTest.CreateContactTest;

public class CreateAndDeleteOrganizationTest extends CreateOrganizationTest{
	public void deleteOrganization() {
		CreateOrganizationTest c= new CreateOrganizationTest();
		String name= c.organization;
		System.out.println("Deleting organization started");
		driver.findElement(By.name("Delete")).click();

		Alert a =driver.switchTo().alert();
		a.accept();

		driver.findElement(By.className("txtBox")).sendKeys(name);

		WebElement searchfield = driver.findElement(By.id("bas_searchfield"));
		Select s= new Select(searchfield);
		s.selectByIndex(1);
		driver.findElement(By.name("submit")).click();
		String text = driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).getText();
		
		if(text.contains("No Organization Found")) {
			System.out.println(" Organization deleted succesfully");
		}
		else {
			System.out.println(" Organization not deleted");
		}
	}
	
	public void finaldelete() {
		
		System.out.println(" Organizations all delete started ");
		driver.findElement(By.linkText("Organizations")).click();
	}
}
