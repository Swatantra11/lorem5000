package com.crm.reqing.ProductTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.reqing.GenericUtility.BaseClass;
import com.crm.reqing.GenericUtility.ExcelUtility;
import com.crm.reqing.POMReposatory.CreatingNewProductPage;
import com.crm.reqing.POMReposatory.HomePage;
import com.crm.reqing.POMReposatory.ProductInformationPage;
import com.crm.reqing.POMReposatory.ProductsPage;


@Listeners(com.crm.reqing.GenericUtility.ListenerImplimentation.class)
public class CreateProductTest1 extends BaseClass{
	@Test(groups = {"smokeTest","regressionTest"},retryAnalyzer =com.crm.reqing.GenericUtility.RetryTryImplimentation.class)
public void CreateProductWithMandatoryTest() throws Throwable{

		ExcelUtility eLib= new ExcelUtility();
		
		HomePage home=new HomePage(driver);
		ProductsPage product=new ProductsPage(driver);
		CreatingNewProductPage create=new CreatingNewProductPage(driver);
		ProductInformationPage info=new ProductInformationPage(driver);
		

		String productname = eLib.getDataFromExcel("product", 1, 1);

		System.out.println(" Create product started ");
		home.getProductsLink().click();
		product.getCreateProductButton().click();
		create.CreateProductWithMandatory(driver, productname); 
		info.validateHeader(productname);
	}

@Test(groups = {"regressionTest"},retryAnalyzer =com.crm.reqing.GenericUtility.RetryTryImplimentation.class)
public void CreateProductWithVendorsLookupTest() throws Throwable {
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
	create.CreateProductWithVendor(productname, childwindow, parentwindow, vendor, 0);
	info.validateHeader(productname);
}
}