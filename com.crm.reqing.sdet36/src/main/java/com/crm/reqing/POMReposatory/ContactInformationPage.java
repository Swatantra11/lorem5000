package com.crm.reqing.POMReposatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.crm.reqing.GenericUtility.ExcelUtility;
import com.crm.reqing.GenericUtility.WebDriverUtility;

public class ContactInformationPage extends WebDriverUtility{
	WebDriver driver;
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//COMMAN TO ALL
	@FindBy(partialLinkText = "Calendar")
	private WebElement CalendarLink;
	@FindBy(partialLinkText = "Leads")
	private WebElement LeadsLink;
	@FindBy(partialLinkText ="Organizations" )
	private WebElement OrganizationsLink ;
	@FindBy(partialLinkText = "Contacts")
	private WebElement ContactsLink;
	@FindBy(partialLinkText = "Opportunities")
	private WebElement OpportunitiesLink;
	@FindBy(partialLinkText ="Products" )
	private WebElement ProductsLink;
	@FindBy(partialLinkText = "Documents")
	private WebElement DocumentsLink ;
	@FindBy(partialLinkText = "Email" )
	private WebElement EmailLink;
	@FindBy(partialLinkText = "Trouble Tickets")
	private WebElement TroubleTicketsLink ;
	@FindBy(partialLinkText = "Dashboard")
	private WebElement DashboardLink;
	@FindBy(xpath="//a[text()='More']")
	private WebElement Moredropdown;
	@FindBy(id ="qccombo" )
	private WebElement QuickCreateDropDown;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']" )
	private WebElement Signoutimg;
	@FindBy(partialLinkText = "Sign Out" )
	private WebElement SignoutLink;
	@FindBy(name="Campaigns")
	private WebElement campaignlink;
	@FindBy(partialLinkText = "Vendors")
	private WebElement VendorsLink;
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreateContactButton ;
	
	
	//page
		@FindBy(className="crmbutton small delete")
		private WebElement deletebutton;
		@FindBy(name="Duplicate")
		private WebElement Duplicatebutton;
		@FindBy(className="crmbutton small edit")
		private WebElement editbutton ;
		@FindBy(className="dvHeaderText")
		private WebElement headerText ;
		
		
		
		
		
		
		public WebDriver getDriver() {
			return driver;
		}






		public WebElement getCalendarLink() {
			return CalendarLink;
		}






		public WebElement getLeadsLink() {
			return LeadsLink;
		}






		public WebElement getOrganizationsLink() {
			return OrganizationsLink;
		}






		public WebElement getContactsLink() {
			return ContactsLink;
		}






		public WebElement getOpportunitiesLink() {
			return OpportunitiesLink;
		}






		public WebElement getProductsLink() {
			return ProductsLink;
		}






		public WebElement getDocumentsLink() {
			return DocumentsLink;
		}






		public WebElement getEmailLink() {
			return EmailLink;
		}






		public WebElement getTroubleTicketsLink() {
			return TroubleTicketsLink;
		}






		public WebElement getDashboardLink() {
			return DashboardLink;
		}






		public WebElement getMoredropdown() {
			return Moredropdown;
		}






		public WebElement getQuickCreateDropDown() {
			return QuickCreateDropDown;
		}






		public WebElement getSignoutimg() {
			return Signoutimg;
		}






		public WebElement getSignoutLink() {
			return SignoutLink;
		}






		public WebElement getCampaignlink() {
			return campaignlink;
		}






		public WebElement getVendorsLink() {
			return VendorsLink;
		}






		public WebElement getCreateContactButton() {
			return CreateContactButton;
		}






		public WebElement getDeletebutton() {
			return deletebutton;
		}






		public WebElement getDuplicatebutton() {
			return Duplicatebutton;
		}






		public WebElement getEditbutton() {
			return editbutton;
		}






		public WebElement getHeaderText() {
			return headerText;
		}



		public void deleteAndVerify(String Contactname ) throws Throwable {
		
			WebDriverUtility webLib=new WebDriverUtility();
			ContactsPage contact=new ContactsPage(driver);
			ExcelUtility eLib=new ExcelUtility();
			deletebutton.click();
			webLib.swithToAlertWindowAndAccpect(driver, eLib.getDataFromExcel("contacts", 1, 4));
			
			contact.getSearchtbx().sendKeys(Contactname);
			WebElement searchType = contact.getSearchfieldDropDown();
			webLib.select(searchType, 2);
			contact.getSearchNowButton().click();
			
			String text=contact.getVerificationMessage().getText();
			softa.assertTrue(text.contains("No Contact Found"));
//			if(text.contains("No Contact Found")) {
//				System.out.println(" contact deleted succesfully");
//			}
//			else {
//				System.out.println(" contact not deleted");
//			}
		}
		


		public void validateHeader(String expectedname) {
			
			String contact=headerText.getText();
			softa.assertTrue(contact.contains(expectedname));
			softa.assertAll();
//			if(contact.contains(expectedname)) {
//				System.out.println(" Contact created sucessfully ");
//			}
//			else {
//				System.out.println(" Contact not created  ");
//			}
		}
}
