package com.crm.tyss.Products;

import org.testng.annotations.Test;

import com.crm.tyss.GenericUtility.BaseClass;
import com.crm.tyss.GenericUtility.ExcelUtility;
import com.crm.tyss.POMReposatory.CreatingNewProductPage;
import com.crm.tyss.POMReposatory.HomePage;
import com.crm.tyss.POMReposatory.ProductInformationPage;
import com.crm.tyss.POMReposatory.ProductsPage;

public class CreateProductTest extends BaseClass{

	@Test(groups = {"smokeTest","regressionTest"})
	public  void CreateProductWithMandatory() throws Throwable {
		ExcelUtility eLib= new ExcelUtility();

		HomePage home=new HomePage(driver);
		ProductsPage product=new ProductsPage(driver);
		CreatingNewProductPage create=new CreatingNewProductPage(driver);
		ProductInformationPage info=new ProductInformationPage(driver);

		String productname = eLib.getDataFromExcel("product", 6, 0);

		System.out.println(" Create product started ");
		home.getProductsLink().click();
		product.getCreateProductButton().click();
		create.CreateProductWithMandatory(driver, productname);

		info.validateHeader(productname);
	}
	@Test(groups = {"regressionTest"})
	public void CreateProductWithVendorsTest() throws Throwable {
		ExcelUtility eLib= new ExcelUtility();
		HomePage home=new HomePage(driver);
		ProductsPage product=new ProductsPage(driver);
		CreatingNewProductPage create=new CreatingNewProductPage(driver);
		ProductInformationPage info=new ProductInformationPage(driver);

		String productname = eLib.getDataFromExcel("product", 1, 0);
		String vendor =eLib.getDataFromExcel("vendors", 1, 1);
		String childwindow = eLib.getDataFromExcel("product", 1, 2);
		String parentwindow = eLib.getDataFromExcel("product", 1, 3);

		System.out.println(" Create product started ");
		home.getProductsLink().click();
		product.getCreateProductButton().click();

		//test start
		create.CreateProductWithVendor(productname, childwindow, parentwindow, vendor, 0);

		info.validateHeader(productname);
	}

//	@Test
//	public void Create_Productwith_MarketingGroupTest() {
//		HomePage home=new HomePage(driver);
//		ProductInformationPage info=new ProductInformationPage(driver);
//
//		home.getQuickCreateDropDown();
//
//		String productname=wb.getSheet("product").getRow(6).getCell(0).getStringCellValue();
//		System.out.println(productname);
//		WebElement quickList = driver.findElement(By.id("qccombo"));
//		Select s= new Select(quickList);
//		s.selectByVisibleText("New Product");
//
//		driver.findElement(By.name("productname")).sendKeys(productname);
//		driver.findElement(By.xpath("//input[@value='T']")).click();
//
//		WebElement groupList = driver.findElement(By.name("assigned_group_id"));
//		Select sg= new Select(groupList);
//		sg.selectByVisibleText("Marketing Group");
//		driver.findElement(By.name("button")).click();
//	}

}
