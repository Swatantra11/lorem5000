package com.crm.tyss.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.tyss.generic.MainClass;

public class SearchProduct_by_ProductNoTest extends MainClass{

	public void SearchProduct_ByNumber() throws Exception {
		String productname=wb.getSheet("product").getRow(9).getCell(0).getStringCellValue();
		System.out.println(productname);
		
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productname);
		driver.findElement(By.name("button")).click();

		String productno = driver.findElement(By.xpath("//td[text()='Product No']/..//td[4]")).getText();

		String text = driver.findElement(By.className("lvtHeaderText")).getText();
		if(text.contains(productname)) {
			System.out.println(" CreateProductbyproductlink test pass ");
		}
		else {
			System.out.println(" CreateProductbyproductlink test fail ");
		}

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.name("search_text")).sendKeys(productno);
		WebElement searchbylist = driver.findElement(By.id("bas_searchfield"));
		Select s =new Select(searchbylist);
		s.selectByVisibleText("Product No");
		driver.findElement(By.name("submit")).click();
		
		
//		WebElement wb1=	driver.findElement(By.xpath("//a[@title='Products']"));
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(wb1));
		
	Thread.sleep(3000);
		
		String search = driver.findElement(By.xpath("//a[@title='Products']")).getText();
		System.out.println(search);
		if(search.contains(productname)) {
			System.out.println(" Search_ProductBy_ProductNumber test pass ");
		}
		else {
			System.out.println(" Search_ProductBy_ProductNumber test fail ");
		}

	}

}
