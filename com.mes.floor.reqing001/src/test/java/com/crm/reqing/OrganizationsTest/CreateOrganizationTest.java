package com.crm.reqing.OrganizationsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

import com.crm.reqing.loginTest.LoginTest;

public class CreateOrganizationTest extends LoginTest{
	
	public static String organization;
	public void createorganization() throws Exception {
		Random ran =new Random();
		int num= 1+ran.nextInt(100);
		
		String data = wb.getSheet("organization").getRow(1).getCell(1).getStringCellValue();
		
		organization=data+num;
		System.out.println("Create organization test started");
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(organization);
		driver.findElement(By.name("button")).click();
		
		String actualorganization = driver.findElement(By.className("dvHeaderText")).getText();
		
		if(actualorganization.contains(organization)) {
		System.out.println(" Create organization test is passed ");	
		
		}
		else {
			System.out.println(" Create organization test is failed ");	
		}
		
		CreateAndDeleteOrganizationTest cdot=new CreateAndDeleteOrganizationTest();
		cdot.deleteOrganization();
		
	}
}
