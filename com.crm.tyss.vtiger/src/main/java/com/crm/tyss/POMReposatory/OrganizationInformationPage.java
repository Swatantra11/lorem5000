package com.crm.tyss.POMReposatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.tyss.GenericUtility.ExcelUtility;
import com.crm.tyss.GenericUtility.WebDriverUtility;

public class OrganizationInformationPage extends WebDriverUtility{
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {
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
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateOrganizationButton ;
	
	
	
	//page
		@FindBy(name = "Delete")
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





		public WebElement getCreateOrganizationButton() {
			return CreateOrganizationButton;
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



		public void deleteAndVerify(String Organizationname ) throws Throwable {
			
			ExcelUtility eLib=new ExcelUtility();
			deletebutton.click();
			swithToAlertWindowAndAccpect(driver, eLib.getDataFromExcel("organization", 1, 4));
		
			OrganizationPage org=new OrganizationPage(driver);
			org.getSearchtbx().sendKeys(Organizationname);
			WebElement searchType = org.getSearchfieldDropDown();
			select(searchType, 1);
			org.getSearchNowButton().click();
			
			String text=org.getVerificationMessage().getText();
			
			if(text.contains("No Organization Found")) {
				System.out.println(" Organizatin deleted succesfully");
			}
			else {
				System.out.println(" Organizatin not deleted");
			}
		}
		

		public void validateHeader(String expectedname) {
			String campname=headerText.getText();
			if(campname.contains(expectedname)) {
				System.out.println(" Organization created sucessfully ");
			}
			else {
				System.out.println(" Organization not created  ");
			}
		}
}
