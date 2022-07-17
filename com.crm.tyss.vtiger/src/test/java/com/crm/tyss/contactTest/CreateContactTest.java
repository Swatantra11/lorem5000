package com.crm.tyss.contactTest;

import org.testng.annotations.Test;
import com.crm.tyss.GenericUtility.BaseClass;
import com.crm.tyss.GenericUtility.ExcelUtility;
import com.crm.tyss.GenericUtility.JavaUtility;
import com.crm.tyss.POMReposatory.ContactInformationPage;
import com.crm.tyss.POMReposatory.ContactsPage;
import com.crm.tyss.POMReposatory.CreatingNewContactPage;
import com.crm.tyss.POMReposatory.HomePage;



public class CreateContactTest extends BaseClass{
	
@Test(groups = {"smokeTest","regressionTest"})
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
@Test(groups = {"regressionTest"})
public void CreateContactWithOrganizationTest() throws Throwable {
	ExcelUtility eLib= new ExcelUtility();
	JavaUtility jLib= new JavaUtility();
	
	HomePage home=new HomePage(driver);
	ContactsPage contact=new ContactsPage(driver);
	CreatingNewContactPage create=new CreatingNewContactPage(driver);
	ContactInformationPage info=new ContactInformationPage(driver);
	
	String name = eLib.getDataFromExcel("contacts", 1, 0);
	String childWindow = eLib.getDataFromExcel("contacts", 1, 2);
	String Parentwindow = eLib.getDataFromExcel("contacts", 1, 3);
	String organiztion = eLib.getDataFromExcel("organization", 1, 0);
	
	String lastname=name+jLib.getRanDomNumber();
	
	home.getContactsLink().click();
	contact.getCreateContactButton().click();
	create.CreateContactWithMandatory(lastname);
	create.CreateContactWithOrganization(lastname, childWindow, Parentwindow, organiztion, 0);
	info.validateHeader(lastname);
}
}
