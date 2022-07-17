package com.crm.tyss.OrganizationsTest;


import org.testng.annotations.Test;

import com.crm.tyss.GenericUtility.BaseClass;
import com.crm.tyss.GenericUtility.ExcelUtility;
import com.crm.tyss.GenericUtility.JavaUtility;
import com.crm.tyss.POMReposatory.CreatingNewOrganizationPage;
import com.crm.tyss.POMReposatory.HomePage;
import com.crm.tyss.POMReposatory.OrganizationInformationPage;
import com.crm.tyss.POMReposatory.OrganizationPage;

public class CreateOrganizationTest extends BaseClass{
	
	@Test(groups = {"smokeTest","regressionTest"})
	public void CreateCampainsWithMandatory() throws Throwable {
		
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		
		HomePage home=new HomePage(driver);
		OrganizationPage org=new OrganizationPage(driver);
		CreatingNewOrganizationPage create=new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage info=new OrganizationInformationPage(driver);
		

		String data =eLib.getDataFromExcel("organization", 1, 10) ;
		String organization = data+jLib.getRanDomNumber();
		
		home.getOrganizationsLink().click();
		org.getCreateOrganizationButton().click();
		create.CreateCampainsWithMandatory(driver, organization);
		info.validateHeader(organization);
	}
	@Test(groups = {"regressionTest"})
	public void CreateOrganizationWithMemberOfTest() throws Throwable {
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		HomePage home=new HomePage(driver);
		OrganizationPage org=new OrganizationPage(driver);
		CreatingNewOrganizationPage create=new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage info=new OrganizationInformationPage(driver);
		
		
		String parentwindow = eLib.getDataFromExcel("organization", 1, 2);
		String childwindow = eLib.getDataFromExcel("organization", 1, 3);
		String data =eLib.getDataFromExcel("organization", 1, 0) ;
		String organization = data+jLib.getRanDomNumber();
		
		home.getOrganizationsLink().click();
		org.getCreateOrganizationButton().click();
		create.CreateCampainsWithMemberOrganization(organization, childwindow, parentwindow, organization, 0);
		info.validateHeader(organization);
	}
}
