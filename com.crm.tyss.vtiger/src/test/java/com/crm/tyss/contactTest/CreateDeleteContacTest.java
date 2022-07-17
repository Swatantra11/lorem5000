package com.crm.tyss.contactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.tyss.GenericUtility.BaseClass;
import com.crm.tyss.GenericUtility.ExcelUtility;
import com.crm.tyss.GenericUtility.FileUtiltiy;
import com.crm.tyss.GenericUtility.JavaUtility;
import com.crm.tyss.GenericUtility.WebDriverUtility;
import com.crm.tyss.POMReposatory.ContactInformationPage;
import com.crm.tyss.POMReposatory.ContactsPage;
import com.crm.tyss.POMReposatory.CreatingNewContactPage;
import com.crm.tyss.POMReposatory.HomePage;
import com.crm.tyss.POMReposatory.LoginPage;

public class CreateDeleteContacTest extends BaseClass{

	public static void main(String [] args) throws Throwable {

		WebDriver driver=new ChromeDriver();

		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		FileUtiltiy fLib=new FileUtiltiy();

		LoginPage login =new LoginPage(driver);
		HomePage home=new HomePage(driver);
		ContactsPage contact=new ContactsPage(driver);
		CreatingNewContactPage create=new CreatingNewContactPage(driver);
		ContactInformationPage info=new ContactInformationPage(driver);

		String name = eLib.getDataFromExcel("contacts", 1, 0);
		String childWindow = eLib.getDataFromExcel("contacts", 1, 2);
		String Parentwindow = eLib.getDataFromExcel("contacts", 1, 3);
		String organiztion = eLib.getDataFromExcel("organization", 1, 0);

		String lastname=name+jLib.getRanDomNumber();

		login.loginToApp(fLib.getPropertyKeyValue("url"), fLib.getPropertyKeyValue("username"), fLib.getPropertyKeyValue("password"));
		System.out.println("Create contact test is started");

		home.getContactsLink().click();
		contact.getCreateContactButton().click();
		create.CreateContactWithMandatory(lastname);
		create.addOrganization(childWindow, Parentwindow, organiztion, 0);
		create.getSaveButton().click();
		info.validateHeader(lastname);

		System.out.println("contact deleting started ");
		info.deleteAndVerify(lastname);
		home.SignOut();
	}
}
