package com.crm.reqing.POMReposatory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.reqing.GenericUtility.WebDriverUtility;

public class CreatingNewCampaignPage extends WebDriverUtility{
	WebDriver driver;
	public CreatingNewCampaignPage(WebDriver driver) {
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
	private WebElement SignoutImg;
	@FindBy(partialLinkText = "Sign Out" )
	private WebElement SignoutLink;
	@FindBy(name="Campaigns")
	private WebElement campaignlink;
	@FindBy(partialLinkText = "Vendors")
	private WebElement VendorsLink;
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement CreatecampaignButton ;
	
	
	//page
	@FindBy (name="campaignname")
	private WebElement CamapaignNameTbx;
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
	private WebElement firstproductname ;
	@FindBy (xpath = "//img[@title='Select']")
	private WebElement addProductButton;
//	@FindBy ()
//	private WebElement ;
	
	

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



	public WebElement getSignoutImg() {
		return SignoutImg;
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



	public WebElement getCreatecampaignButton() {
		return CreatecampaignButton;
	}



	public WebElement getCamapaignNameTbx() {
		return CamapaignNameTbx;
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



	public WebElement getFirstproductname() {
		return firstproductname;
	}



	public WebElement getAddProductButton() {
		return addProductButton;
	}

	
	public void CreateCampaignsWithMandatory(WebDriver driver,String name) {
		CreatecampaignButton.click();
		CamapaignNameTbx.sendKeys(name);
		saveButton.click();
		
	}


	public void CreateCampaignWithProduct(String campaignname, String childwindow,String parentwindow,String productname, int index) {
		CreatecampaignButton.click();
		CamapaignNameTbx.sendKeys(campaignname);
		WebDriverUtility webLib =new WebDriverUtility();
		addProductButton.click();
		webLib.swithToWindow(driver, childwindow);
		
		searchtbx.sendKeys(productname);
		webLib.select(searchdropdown, index);
		searchnowbutton.click();
		firstproductname.click();
		webLib.swithToWindow(driver, parentwindow);
		saveButton.click();
	}
	
	
}
