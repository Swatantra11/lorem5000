package com.crm.reqing.loginTest;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.reqing.CamapinsTest.CreateCampainsTest;
import com.crm.reqing.DataUpload.FileLibTest;
import com.crm.reqing.OrganizationsTest.CreateOrganizationTest;
import com.crm.reqing.ProductTest.CreateProductTest;
import com.crm.reqing.contactTest.CreateContactTest;
import com.crm.reqing.deleteAll.DeleteAllTest;



public class LoginTest extends FileLibTest {

	public static WebDriver driver;
	public static Workbook wb ;
	public static void main(String[] args) throws Exception {
		FileLibTest pfile = new FileLibTest();
		pfile.getPropertyData();
		pfile.getexceldata();
		wb=pfile.book;

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(" login ");
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		
		System.out.println(" login successfully");
		System.out.println();
		
		CreateProductTest cpt=new CreateProductTest();
		cpt.createProduct();
		System.out.println();
		  
		CreateCampainsTest cnct=new CreateCampainsTest();
		cnct.createcampians();
		System.out.println();

		CreateContactTest cct=new CreateContactTest();
		cct.createcontact();
		System.out.println();

		CreateOrganizationTest cot =new CreateOrganizationTest();
		cot.createorganization();
		System.out.println();
		
		System.out.println(" All delete Started ");
		DeleteAllTest del = new DeleteAllTest();
		del.deleteall();

		Actions a=  new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println(" logout successfully");
		driver.close();


	}
}
