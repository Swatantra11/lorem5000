package com.crm.reqing.POMReposatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.reqing.GenericUtility.WebDriverUtility;


public class CreatingNewContactPage extends WebDriverUtility{
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {
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
	@FindBy (name="lastname")
	private WebElement lastnameTbx;
	@FindBy (name ="button")
	private WebElement saveButton;
	
	//addbutton
		@FindBy (name="search_field")
		private WebElement searchdropdown;
		@FindBy (name="search")
		private WebElement searchnowbutton;
		@FindBy (id="search_txt")
		private WebElement searchtbx;
		@FindBy (xpath="//a[@alt='Next']")
		private WebElement nextpagebutton;
		@FindBy (id="1")
		private WebElement firstorganizationtname ;
		@FindBy (xpath = "//img[@title='Select']")
		private WebElement addOranizatinButton;
		
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

		public WebElement getLastnameTbx() {
			return lastnameTbx;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}

		public WebElement getSearchdropdown() {
			return searchdropdown;
		}

		public WebElement getSearchnowbutton() {
			return searchnowbutton;
		}

		public WebElement getSearchtbx() {
			return searchtbx;
		}

		public WebElement getNextpagebutton() {
			return nextpagebutton;
		}

		public WebElement getFirstorganizationtname() {
			return firstorganizationtname;
		}

		public WebElement getAddOranizatinButton() {
			return addOranizatinButton;
		}

		public void CreateContactWithMandatory(String lastname) {
			CreateContactButton.click();
			lastnameTbx.sendKeys(lastname);
			saveButton.click();
			
		}
		
		public void CreateContactWithOrganization(String lastname, String childwindow,String parentwindow,String OrganizationName , int index) {
			CreateContactButton.click();
			lastnameTbx.sendKeys(lastname);
			WebDriverUtility webLib =new WebDriverUtility();
			addOranizatinButton.click();
			
			webLib.swithToWindow(driver, childwindow);
			
			searchtbx.sendKeys(OrganizationName );
			webLib.select(searchdropdown, index);
			searchnowbutton.click();
			firstorganizationtname.click();
			webLib.swithToWindow(driver, parentwindow);
			saveButton.click();
		}
}
