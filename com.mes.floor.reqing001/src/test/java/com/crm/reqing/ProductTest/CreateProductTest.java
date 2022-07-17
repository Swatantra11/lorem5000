package com.crm.reqing.ProductTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

import com.crm.reqing.loginTest.LoginTest;

public class CreateProductTest extends LoginTest {
	
	public static String productname;
	public void createProduct() throws Exception {
		
		productname = wb.getSheet("product").getRow(1).getCell(1).getStringCellValue();
		System.out.println(" Create product started ");
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productname);
		driver.findElement(By.name("button")).click();
		
		String actualproductname = driver.findElement(By.className("lvtHeaderText")).getText();
		
		if(actualproductname.contains(productname)) {
		System.out.println(" Create product test is passed ");		
		}
		else {
			System.out.println(" Create product test is failed ");	
		}
		
		//	CreateAndDeleteProductTest cdpt=new CreateAndDeleteProductTest();
//		cdpt.deleteproduct();	
	}
}
