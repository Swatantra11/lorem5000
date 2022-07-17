package com.crm.reqing.CamapinsTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.reqing.GenericUtility.BaseClass;
import com.crm.reqing.POMReposatory.CampaignInformationPage;
import com.crm.reqing.POMReposatory.CampaignsPage;
import com.crm.reqing.POMReposatory.CreatingNewCampaignPage;
import com.crm.reqing.POMReposatory.HomePage;


@Listeners(com.crm.reqing.GenericUtility.ListenerImplimentation.class)
public class CreateCampaignTest1 extends BaseClass {
@Test(groups = {"smokeTest","regressionTest"},invocationCount = 1 ,retryAnalyzer =com.crm.reqing.GenericUtility.RetryTryImplimentation.class)
//(enabled = false)
public void createCampaignWithMandatoryFieldTest() throws Throwable {
	
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
	info.validateHeader(campname);
	
}
@Test(groups = {"regressionTest"},retryAnalyzer =com.crm.reqing.GenericUtility.RetryTryImplimentation.class)
public void CreateCampaignWithProductTest() throws Throwable {
	HomePage home =new HomePage(driver);
	CampaignsPage campaign = new CampaignsPage(driver);
	CreatingNewCampaignPage create =new CreatingNewCampaignPage(driver);
	CampaignInformationPage info=new CampaignInformationPage(driver);

	String data = eLib.getDataFromExcel("campaign", 1, 1);
	int num=jLib.getRanDomNumber();
	String campaigname = data+num;


	
	home.MoreLinkHover();
	home.getCampaignsLink().click();
	campaign.navigateToCreate();	
	

	String productname = eLib.getDataFromExcel("product", 1, 1);
	String parentwindow=eLib.getDataFromExcel("campaign", 1, 2);
	String childwindow=eLib.getDataFromExcel("campaign", 1, 3);

	create.CreateCampaignWithProduct(campaigname, childwindow, parentwindow, productname, 0);
	System.out.println("Product added succesfully");
	info.validateHeader(campaigname);
}

}
