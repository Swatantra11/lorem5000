package com.crm.tyss.Products;

import org.openqa.selenium.By;

import com.crm.tyss.generic.MainClass;

public class CreateProductbyproductlinkTest extends MainClass{
	
	public void CreateProductbyproductlink(){
		String productname=wb.getSheet("product").getRow(8).getCell(0).getStringCellValue();
		System.out.println(productname);
		
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
	}
}
