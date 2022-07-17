package com.crm.reqing.POMReposatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.reqing.GenericUtility.WebDriverUtility;

public class ContactsPage extends WebDriverUtility{
	WebDriver driver;
	public ContactsPage(WebDriver driver) {
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
	
	
	//ONLY PAGED
		@FindBy(xpath = "//img[@title='Create Contact...']")
		private WebElement CreateContactButton ;
		@FindBy(id = "bas_searchfield" )
		private WebElement searchfieldDropDown ;
		@FindBy(name ="search_text"  )
		private WebElement searchtbx ;
		@FindBy(name = "submit" )
		private WebElement SearchNowButton;
		@FindBy(xpath = "//span[@class='genHeaderSmall']")
		private WebElement VerificationMessage;
		
		
		
		public WebElement getVerificationMessage() {
			return VerificationMessage;
		}
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
		public WebElement getSearchfieldDropDown() {
			return searchfieldDropDown;
		}
		public WebElement getSearchtbx() {
			return searchtbx;
		}
		public WebElement getSearchNowButton() {
			return SearchNowButton;
		}

		
		
		
}
