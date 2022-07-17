package com.crm.reqing.POMReposatory;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.*;


import com.crm.reqing.GenericUtility.ExcelUtility;
import com.crm.reqing.GenericUtility.WebDriverUtility;

public class CampaignInformationPage extends WebDriverUtility{
	WebDriver driver;
	public CampaignInformationPage(WebDriver driver) {
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
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement CreateCampaignButton ;
	
	//page
	@FindBy(name="Delete")
	private WebElement deletebutton;
	@FindBy(name="Duplicate")
	private WebElement Duplicatebutton;
	@FindBy(className="crmbutton small edit")
	private WebElement editbutton ;
	@FindBy(className="dvHeaderText")
	private WebElement headerText ;
//	@FindBy()
//	private WebElement ;
//	@FindBy()
//	private WebElement ;
//	@FindBy()
//	private WebElement ;
//	@FindBy()
//	private WebElement ;
//	@FindBy()
//	private WebElement ;
//	@FindBy()
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





	public WebElement getCampaignlink() {
		return campaignlink;
	}





	public WebElement getVendorsLink() {
		return VendorsLink;
	}





	public WebElement getCreateCampaignButton() {
		return CreateCampaignButton;
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
	
	public void deleteAndVerify(String Campaignname ) throws Throwable {
		WebDriverUtility weblib= new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		deletebutton.click();
		weblib.swithToAlertWindowAndAccpect(driver, eLib.getDataFromExcel("campaign", 1, 4));
		WebDriverUtility webLib=new WebDriverUtility();
		CampaignsPage camp=new CampaignsPage(driver);
		camp.getSearchtbx().sendKeys(Campaignname);
		WebElement searchType = camp.getSearchfieldDropDown();
		webLib.select(searchType, 1);
		camp.getSearchNowButton().click();
		
		String text=camp.getVerificationMessage().getText();
		Assert.assertTrue(text.contains("No Campaign Found"));
		
//		if(text.contains("No Campaign Found")) {
//			System.out.println(" Campaign deleted succesfully");
//		}
//		else {
//			System.out.println(" Campaign not deleted");
//		}
	}
	
	public void validateHeader(String expectedname) {
		String campname=headerText.getText();
		Assert.assertTrue(campname.contains(expectedname));
		
//		softa.assertTrue(campname.contains(expectedname));
//		softa.assertAll();
//		if(campname.contains(expectedname)) {
//			System.out.println(" camapign created sucessfully ");
//		}
//		else {
//			System.out.println(" camapign not created  ");
//		}
	}
}
