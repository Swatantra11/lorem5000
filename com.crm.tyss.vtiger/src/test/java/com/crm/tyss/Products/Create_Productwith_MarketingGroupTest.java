package com.crm.tyss.Products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.tyss.GenericUtility.ExcelUtility;
import com.crm.tyss.GenericUtility.WebDriverUtility;
import com.crm.tyss.POMReposatory.HomePage;
import com.crm.tyss.POMReposatory.ProductInformationPage;



public class Create_Productwith_MarketingGroupTest extends WebDriverUtility {
	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();

		HomePage home=new HomePage(driver);
		ProductInformationPage info=new ProductInformationPage(driver);
ExcelUtility e= new ExcelUtility();
WebDriverUtility webLib= new WebDriverUtility(); 
		WebElement quickList = home.getQuickCreateDropDown();

		String productname=e.getDataFromExcel("product", 6, 0);
				
		System.out.println(productname);
		webLib.select(quickList, "New Product");
//		Select s= new Select(quickList);
//		s.selectByVisibleText("New Product");

		driver.findElement(By.name("productname")).sendKeys(productname);
		driver.findElement(By.xpath("//input[@value='T']")).click();

		WebElement groupList = driver.findElement(By.name("assigned_group_id"));
		Select sg= new Select(groupList);
		sg.selectByVisibleText("Marketing Group");
		driver.findElement(By.name("button")).click();


	}

}
