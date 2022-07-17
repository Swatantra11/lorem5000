package com.crm.tyss.Products;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.tyss.GenericUtility.ExcelUtility;
import com.crm.tyss.GenericUtility.FileUtiltiy;
import com.crm.tyss.GenericUtility.WebDriverUtility;
import com.crm.tyss.POMReposatory.CreatingNewProductPage;
import com.crm.tyss.POMReposatory.HomePage;
import com.crm.tyss.POMReposatory.LoginPage;
import com.crm.tyss.POMReposatory.ProductInformationPage;
import com.crm.tyss.POMReposatory.ProductsPage;


public class CreateAndDeleteProductTest extends WebDriverUtility{

	public static void main(String [] args) throws Throwable {

		WebDriver driver=new ChromeDriver();

		ExcelUtility eLib= new ExcelUtility();
		FileUtiltiy fLib=new FileUtiltiy();

		LoginPage login =new LoginPage(driver);
		HomePage home=new HomePage(driver);
		ProductsPage product=new ProductsPage(driver);
		CreatingNewProductPage create=new CreatingNewProductPage(driver);
		ProductInformationPage info=new ProductInformationPage(driver);


		login.loginToApp(fLib.getPropertyKeyValue("url"), fLib.getPropertyKeyValue("username"), fLib.getPropertyKeyValue("password"));

		String productname = eLib.getDataFromExcel("product", 1, 0);
		String vendor =eLib.getDataFromExcel("vendors", 1, 1);
		String childwindow = eLib.getDataFromExcel("product", 1, 2);
		String parentwindow = eLib.getDataFromExcel("product", 1, 3);

		System.out.println(" Create product started ");
		home.getProductsLink().click();
		product.getCreateProductButton().click();
		create.CreateProductWithMandatory(driver, productname);
		create.CreateProductWithVendor(productname, childwindow, parentwindow, vendor, 0);
		create.getSaveButton().click();;
		info.validateHeader(productname);
		info.deleteAndVerifybyName(productname);
		home.SignOut();


	}
}
