package com.crm.reqing.SampleTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.reqing.GenericUtility.BaseClass;
import com.crm.reqing.GenericUtility.ExcelUtility;
import com.crm.reqing.GenericUtility.JavaUtility;
import com.crm.reqing.POMReposatory.ContactInformationPage;
import com.crm.reqing.POMReposatory.ContactsPage;
import com.crm.reqing.POMReposatory.CreatingNewContactPage;
import com.crm.reqing.POMReposatory.HomePage;

@Listeners(com.crm.reqing.GenericUtility.ListenerImplimentation.class)
public class Sample_ContactTest extends BaseClass{
	@Test(groups = {"smokeTest","regressionTest"},retryAnalyzer =com.crm.reqing.GenericUtility.RetryTryImplimentation.class)
	public void CreateContactWithMandatory() throws Throwable {
		ExcelUtility elib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();

		HomePage home=new HomePage(driver);
		ContactsPage contact=new ContactsPage(driver);
		CreatingNewContactPage create=new CreatingNewContactPage(driver);
		ContactInformationPage info=new ContactInformationPage(driver);
		
		String name = elib.getDataFromExcel("contacts", 1, 0);
		String lastname=name+jLib.getRanDomNumber();
		System.out.println("Create contact test is started");
		home.getContactsLink().click();
		contact.getCreateContactButton().click();
		create.CreateContactWithMandatory(lastname);
		
		info.validateHeader(lastname);
	}
	
@Test(groups = {"regressionTest"},retryAnalyzer =com.crm.reqing.GenericUtility.RetryTryImplimentation.class)
public void CreateContactWithOrganizationTest() throws Throwable {
	ExcelUtility eLib= new ExcelUtility();
	JavaUtility jLib= new JavaUtility();
	
	HomePage home=new HomePage(driver);
	ContactsPage contact=new ContactsPage(driver);
	CreatingNewContactPage create=new CreatingNewContactPage(driver);
	ContactInformationPage info=new ContactInformationPage(driver);
	
	
	String childWindow = eLib.getDataFromExcel("contacts", 1, 2);
	String Parentwindow = eLib.getDataFromExcel("contacts", 1, 3);
	String organiztion = eLib.getDataFromExcel("organization", 1, 0);
	String name = eLib.getDataFromExcel("contacts", 1, 0);
	String lastname=name+jLib.getRanDomNumber();
	
	System.out.println("Create contact test is started");
	
	home.getContactsLink().click();
	contact.getCreateContactButton().click();
	
	create.CreateContactWithOrganization(lastname, childWindow, Parentwindow, organiztion, 0);

	info.validateHeader(lastname);
}
}
