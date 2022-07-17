package com.crm.reqing.CamapinsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.crm.reqing.ProductTest.CreateProductTest;
import com.crm.reqing.loginTest.LoginTest;

public class CreateCampainsTest extends LoginTest{
	public static String campname;
	public static String pname;
public void createcampians() throws Exception {
	CreateProductTest c=new CreateProductTest();
	pname = c.productname;
	Random ran = new Random();
	int num= 1+ran.nextInt(100);
	System.out.println(" campaign test started ");
	
	String data = wb.getSheet("campaign").getRow(1).getCell(1).getStringCellValue();
	
	campname=data+num;
	Actions a=  new Actions(driver);
	a.moveToElement(driver.findElement(By.xpath("//a[text()='More']"))).perform();
	driver.findElement(By.name("Campaigns")).click();
	driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	driver.findElement(By.name("campaignname")).sendKeys(campname);
	
	CreateCampaignWithProductTest ccwpt=new CreateCampaignWithProductTest();
	ccwpt.productlookup();
	
	driver.findElement(By.name("button")).click();
	String expectedname = driver.findElement(By.className("dvHeaderText")).getText();
	
	
	if(expectedname.contains(campname)) {
		System.out.println(" camapin created sucessfully ");
	}
	else {
		System.out.println(" camapin not created  ");
	}
	CreateAndDeleteCampaignTest cdct= new CreateAndDeleteCampaignTest();
	cdct.deletecampiagn();
}
}
