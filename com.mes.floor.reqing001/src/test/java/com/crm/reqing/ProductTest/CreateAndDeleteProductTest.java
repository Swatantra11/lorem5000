package com.crm.reqing.ProductTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.crm.reqing.contactTest.CreateContactTest;

public class CreateAndDeleteProductTest extends CreateProductTest {
	public void deleteproduct() {
		CreateProductTest c= new CreateProductTest();
		String name= c.productname;
		String text= "" ;
		System.out.println("Product deleting started ");
		
		driver.findElement(By.name("Delete")).click();

		Alert a =driver.switchTo().alert();
		a.accept();

		driver.findElement(By.className("txtBox")).sendKeys(name);

		WebElement searchfield = driver.findElement(By.id("bas_searchfield"));
		Select s= new Select(searchfield);
		s.selectByIndex(1);
		driver.findElement(By.name("submit")).click();
		try {
		text = driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).getText();
		}
		catch(Exception e) {
			
		}
		finally {
		if(text.contains("No Product Found")) {
			System.out.println(" Product deleted succesfully");
		}
		else {
			System.out.println(" Product not deleted");
		}
		}

	}
	
	public void finaldelete() {
		
		System.out.println(" Products all delete started ");
		driver.findElement(By.linkText("Products")).click();
	}
}
