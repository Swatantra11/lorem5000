package com.crm.tyss.CamapinsTest;

import org.testng.annotations.Test;
import com.crm.tyss.GenericUtility.BaseClass;
import com.crm.tyss.GenericUtility.ExcelUtility;
import com.crm.tyss.GenericUtility.JavaUtility;
import com.crm.tyss.POMReposatory.CampaignInformationPage;
import com.crm.tyss.POMReposatory.CampaignsPage;
import com.crm.tyss.POMReposatory.CreatingNewCampaignPage;
import com.crm.tyss.POMReposatory.HomePage;

public class CreateCampainsTest extends BaseClass{
	@Test(groups = {"smokeTest","regressionTest"})
	public void CreateCampainsWithMandatoryTestthrows() throws Throwable  {

		
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib= new ExcelUtility();

		HomePage home =new HomePage(driver);
		CampaignsPage campaign = new CampaignsPage(driver);
		CreatingNewCampaignPage create =new CreatingNewCampaignPage(driver);
		CampaignInformationPage info=new CampaignInformationPage(driver);
		String data = eLib.getDataFromExcel("campaign", 1, 10);
		int num=jLib.getRanDomNumber();
		String campname = data+num;
		home.MoreLinkHover();
		home.getCampaignsLink().click();
		campaign.navigateToCreate();	
		create.CreateCampaignsWithMandatory(driver, campname);
		info.validateHeader(campname);

	}
	@Test(groups = {"regressionTest"})
	public void CreateCampaignWithProductTest() throws Throwable {

		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib= new ExcelUtility();
		HomePage home =new HomePage(driver);
		CampaignsPage campaign = new CampaignsPage(driver);
		CreatingNewCampaignPage create =new CreatingNewCampaignPage(driver);
		CampaignInformationPage info=new CampaignInformationPage(driver);

		String data = eLib.getDataFromExcel("campaign", 1, 1);
		int num=jLib.getRanDomNumber();
		String campname = data+num;

		home.MoreLinkHover();
		home.getCampaignsLink().click();
		campaign.navigateToCreate();	
		create.CreateCampaignsWithMandatory(driver, campname);

		String productname = eLib.getDataFromExcel("product", 1, 1);
		String parentwindow=eLib.getDataFromExcel("campaign", 1, 2);
		String childwindow=eLib.getDataFromExcel("campaign", 1, 3);

		create.CreateCampaignWithProduct(campname, childwindow, parentwindow, productname, 0);
		System.out.println("Product added succesfully");
		info.validateHeader(campname);
	}
}
