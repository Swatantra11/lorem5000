package com.crm.reqing.OrganizationsTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.reqing.GenericUtility.BaseClass;
import com.crm.reqing.GenericUtility.ExcelUtility;
import com.crm.reqing.GenericUtility.JavaUtility;
import com.crm.reqing.POMReposatory.CreatingNewOrganizationPage;
import com.crm.reqing.POMReposatory.HomePage;
import com.crm.reqing.POMReposatory.OrganizationInformationPage;
import com.crm.reqing.POMReposatory.OrganizationPage;


@Listeners(com.crm.reqing.GenericUtility.ListenerImplimentation.class)
public class CreateOrganizationTest1 extends BaseClass {
	
	@Test(groups = {"smokeTest","regressionTest"},retryAnalyzer =com.crm.reqing.GenericUtility.RetryTryImplimentation.class)
	public void CreateOrganizationWithMandatory() throws Throwable {
	ExcelUtility eLib= new ExcelUtility();
	JavaUtility jLib= new JavaUtility();
	
	HomePage home=new HomePage(driver);
	OrganizationPage org=new OrganizationPage(driver);
	CreatingNewOrganizationPage create=new CreatingNewOrganizationPage(driver);
	OrganizationInformationPage info=new OrganizationInformationPage(driver);
	

	String data =eLib.getDataFromExcel("organization", 1, 0) ;
	String organization = data+jLib.getRanDomNumber();
	
	home.getOrganizationsLink().click();
	org.getCreateOrganizationButton().click();
	create.CreateCampainsWithMandatory(driver, organization);
	info.validateHeader(organization);
	}
@Test(groups = {"regressionTest"},retryAnalyzer =com.crm.reqing.GenericUtility.RetryTryImplimentation.class)
public void CreateOrganizationWithMemberOfTest() throws Throwable {
	
	ExcelUtility eLib= new ExcelUtility();
	JavaUtility jLib= new JavaUtility();
	
	HomePage home=new HomePage(driver);
	OrganizationPage org=new OrganizationPage(driver);
	CreatingNewOrganizationPage create=new CreatingNewOrganizationPage(driver);
	OrganizationInformationPage info=new OrganizationInformationPage(driver);
	
	String addorganization =eLib.getDataFromExcel("organization", 1, 0) ;
	String parentwindow = eLib.getDataFromExcel("organization", 1, 2);
	String childwindow = eLib.getDataFromExcel("organization", 1, 3);
	String data =eLib.getDataFromExcel("organization", 2, 0) ;
	String organization = data+jLib.getRanDomNumber();
	
	home.getOrganizationsLink().click();
	org.getCreateOrganizationButton().click();

	create.CreateCampainsWithMemberOrganization(organization, childwindow, parentwindow, addorganization, 0);
	
	info.validateHeader(organization);
}
}
