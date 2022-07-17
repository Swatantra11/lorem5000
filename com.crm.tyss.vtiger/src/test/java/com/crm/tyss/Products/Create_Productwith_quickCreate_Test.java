package com.crm.tyss.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.crm.tyss.GenericUtility.ExcelUtility;
import com.crm.tyss.GenericUtility.WebDriverUtility;
import com.crm.tyss.OpenBrowser.DriverClass;
import com.crm.tyss.OpenBrowser.LoginTest;



public class Create_Productwith_quickCreate_Test extends DriverClass {
	
public void quickCreateProduct() throws Throwable {
	LoginTest open =new LoginTest();
	WebDriverUtility webLib=new WebDriverUtility();
	ExcelUtility eLib =new ExcelUtility();
	
	open.Login();
	
	String productname=eLib.getDataFromExcel("products", 1, 1);	
	WebElement quickList = driver.findElement(By.id("qccombo"));
	Select sq= new Select(quickList);
	sq.selectByVisibleText("New Product");
	
	driver.findElement(By.name("productname")).sendKeys(productname);

	driver.findElement(By.xpath("//input[@value='U']")).click();
	
	
	driver.findElement(By.name("button")).click();
	String text = driver.findElement(By.className("lvtHeaderText")).getText();
	if(text.contains(productname)) {
		System.out.println(" Productwith_quickCreate test pass ");
	}
	else {
		System.out.println(" Productwith_quickCreate test fail ");
	}
	driver.close();
}
}
