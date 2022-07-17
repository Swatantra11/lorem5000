package com.crm.reqing.contactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

import com.crm.reqing.loginTest.LoginTest;

public class CreateContactTest extends LoginTest{
	static String lastname;
	public void createcontact() throws Exception {
		Random ran=new Random();
		int num= 1+ran.nextInt(100);
		
		String name = wb.getSheet("contacts").getRow(1).getCell(0).getStringCellValue();
		
		 lastname=name+num;
		System.out.println("Create contact test is started");
		
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();	
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys(lastname);
	driver.findElement(By.name("button")).click();
	
	
	String actuallastname = driver.findElement(By.className("dvHeaderText")).getText();
	
	if(actuallastname.contains(lastname)) {
	System.out.println(" Create contact test is passed ");		
	}
	else {
		System.out.println(" Create contact test is failed ");	
	}
	CreateDeleteContacTest cdct =new CreateDeleteContacTest() ;
	cdct.deletecontact();
	}
}
