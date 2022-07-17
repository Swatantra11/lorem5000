package com.crm.tyss.Products;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.tyss.generic.MainClass;

public class Search_ProductBy_ProductnameTest extends MainClass{

public void SearchProductByName() throws Exception {
	String productname=wb.getSheet("product").getRow(8).getCell(0).getStringCellValue();
	System.out.println(productname);
	
	WebDriverWait wait = new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Products']")));
	
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	driver.findElement(By.name("productname")).sendKeys(productname);
	driver.findElement(By.name("button")).click();
	
	String text = driver.findElement(By.className("lvtHeaderText")).getText();
	if(text.contains(productname)) {
		System.out.println(" CreateProductbyproductlink test pass ");
	}
	else {
		System.out.println(" CreateProductbyproductlink test fail ");
	}
	
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.name("search_text")).sendKeys(productname);
	 WebElement searchbylist = driver.findElement(By.id("bas_searchfield"));
	Select s =new Select(searchbylist);
	s.selectByVisibleText("Product Name");
	driver.findElement(By.name("submit")).click();
	 String search = driver.findElement(By.xpath("//a[@title='Products']")).getText();
	 System.out.println(search);
	if(search.contains(productname)) {
		System.out.println(" Search_ProductBy_Productname test pass ");
	}
	else {
		System.out.println(" Search_ProductBy_Productname test fail ");
	}

}
}
