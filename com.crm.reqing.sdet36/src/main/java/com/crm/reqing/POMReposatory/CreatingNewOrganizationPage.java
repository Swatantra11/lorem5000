package com.crm.reqing.POMReposatory;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.reqing.GenericUtility.ExcelUtility;
import com.crm.reqing.GenericUtility.WebDriverUtility;



public class CreatingNewOrganizationPage extends WebDriverUtility{
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
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
	@FindBy (name="accountname")
	private WebElement organizationNameTbx;
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
		private WebElement firstOrganizationname ;
		@FindBy (xpath = "//img[@title='Select']")
		private WebElement addMemberOfButton;
		
		
		
		
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

		public WebElement getOrganizationNameTbx() {
			return organizationNameTbx;
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

		public WebElement getFirstOrganizationname() {
			return firstOrganizationname;
		}

		public WebElement getAddMemberOfButton() {
			return addMemberOfButton;
		}

		public void CreateCampainsWithMandatory(WebDriver driver,String name) {
			CreateOrganizationButton.click();
			organizationNameTbx.sendKeys(name);
			saveButton.click();
			
			
		}
		
		public void CreateCampainsWithMemberOrganization(String organization,String childwindow,String parentwindow,String addOrganozation, int index) throws Throwable {
			CreateOrganizationButton.click();
			organizationNameTbx.sendKeys(organization);
			WebDriverUtility webLib =new WebDriverUtility();
			addMemberOfButton.click();
			Set<String> memberof = driver.getWindowHandles();
			Iterator<String> it =memberof.iterator();
			while(it.hasNext()){
				String wh = it.next();
				driver.switchTo().window(wh);
				String currentTitle = driver.getTitle();
				if(currentTitle.contains(childwindow)) {
					continue;
				}
			}
			//webLib.swithToWindow(driver, childwindow);
			
			searchtbx.sendKeys(addOrganozation);
			webLib.select(searchdropdown, index);
			searchnowbutton.click();
			WebElement ststus = driver.findElement(By.id("status"));
//			WebDriverWait wait= new WebDriverWait(driver, 10);
//			wait.until(ExpectedConditions.invisibilityOf(ststus));
			waitForElementByValue(driver, firstOrganizationname, addOrganozation);
			firstOrganizationname.click();
			ExcelUtility eLib =new ExcelUtility();
			webLib.swithToAlertWindowAndAccpect(driver, eLib.getDataFromExcel("organization", 1, 4));
			webLib.swithToWindow(driver, parentwindow);
			saveButton.click();
		}

		private void waitForElementByValue(WebDriver driver2, WebElement firstOrganizationname2,
				String addOrganozation) {
			// TODO Auto-generated method stub
			
		}
}
