package com.crm.tyss.CamapinsTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.tyss.GenericUtility.BaseClass;
import com.crm.tyss.GenericUtility.ExcelUtility;
import com.crm.tyss.GenericUtility.FileUtiltiy;
import com.crm.tyss.GenericUtility.JavaUtility;
import com.crm.tyss.POMReposatory.CampaignInformationPage;
import com.crm.tyss.POMReposatory.CampaignsPage;
import com.crm.tyss.POMReposatory.CreatingNewCampaignPage;
import com.crm.tyss.POMReposatory.HomePage;
import com.crm.tyss.POMReposatory.LoginPage;

public class CreateAndDeleteCampaignTest extends BaseClass{

	public static void main(String[] args)  throws Throwable{
		
		FileUtiltiy fLib=new FileUtiltiy();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib= new ExcelUtility();

		WebDriver driver=new ChromeDriver();

		HomePage home =new HomePage(driver);
		CampaignsPage campaign = new CampaignsPage(driver);
		CreatingNewCampaignPage create =new CreatingNewCampaignPage(driver);
		CampaignInformationPage info=new CampaignInformationPage(driver);

		String data = eLib.getDataFromExcel("campaign", 1, 1);
		int num=jLib.getRanDomNumber();
		String campname = data+num;


		LoginPage login =new LoginPage(driver);
		login.loginToApp(fLib.getPropertyKeyValue("url"), fLib.getPropertyKeyValue("username"), fLib.getPropertyKeyValue("password"));

		home.MoreLinkHover();
		home.getCampaignsLink().click();
		campaign.navigateToCreate();	
		create.CreateCampaignsWithMandatory(driver, campname);

		String productname = eLib.getDataFromExcel("product", 6, 0);
		String parentwindow=eLib.getDataFromExcel("campaign", 1, 2);
		String childwindow=eLib.getDataFromExcel("campaign", 1, 3);

		create.addProduct(driver, childwindow, parentwindow, productname, 0);
		System.out.println("Product added succesfully");
		create.getSaveButton().click();
		info.validateHeader(campname);
		
		info.deleteAndVerify(campname);  
		home.SignOut();
		
		
	}
	
	
}
