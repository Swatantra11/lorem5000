package com.crm.reqing.POMReposatory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.reqing.GenericUtility.WebDriverUtility;

public class HomePage  extends WebDriverUtility{
	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
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
	@FindBy(xpath = "//a[text()='More']" )
	private WebElement Moredropdown;
	@FindBy(id ="qccombo" )
	private WebElement QuickCreateDropDown;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']" )
	private WebElement Signoutimg;
	@FindBy(partialLinkText = "Sign Out" )
	private WebElement SignoutLink;
	@FindBy(name = "Campaigns" )
	private WebElement CampaignsLink;
//	@FindBy(partialLinkText = "" )
//	private WebElement ;
//	@FindBy(partialLinkText = "" )
//	private WebElement ;
//	@FindBy(partialLinkText = "" )
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



	public WebElement getSignoutimg() {
		return Signoutimg;
	}



	public WebElement getSignoutLink() {
		return SignoutLink;
	}



	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}
	
	public void MoreLinkHover() {
	//WebElement morelink = driver.findElement(By.xpath("//a[text()='More']"));
	mouseOverOnElement(driver, Moredropdown);
	}
	public void SignOut() {
		WebDriverUtility webLib= new WebDriverUtility();
		webLib.mouseOverOnElement(driver, Signoutimg);
		SignoutLink.click();
	}



}
