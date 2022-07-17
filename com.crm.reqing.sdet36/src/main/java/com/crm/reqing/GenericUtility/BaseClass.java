package com.crm.reqing.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.crm.reqing.POMReposatory.HomePage;
import com.crm.reqing.POMReposatory.LoginPage;

public class BaseClass extends WebDriverUtility{
	public WebDriver driver;
	
	
	
	//Object Creation for Lib
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtiltiy fLib = new FileUtiltiy();
	public ExcelUtility eLib = new ExcelUtility();
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	//(groups = {"smokeTest","regressionTest"})
	public void configBS()
	{
		
		System.out.println(" CONNECT TO DATABASE ");
	}
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable {
	System.out.println(" LAUNCH THE BROWSER ");
	//String browser = System.getProperty("browser");
	
	String browser =fLib.getPropertyKeyValue("browser");
	if(browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}
	else if (browser.equalsIgnoreCase("firefox")) {
		driver= new FirefoxDriver();
	}
	else if(browser.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
	}
	else {
		driver=new ChromeDriver();
	}
	sdriver= driver;
	
	wLib.waitForElementInDOM(driver);
	driver.manage().window().maximize();

	
	}


	
	
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable
	{
	System.out.println();
	String username =fLib.getPropertyKeyValue("username");
	String password = fLib.getPropertyKeyValue("password");
	String url = fLib.getPropertyKeyValue("url");
	LoginPage login =new LoginPage(driver);
	login.loginToApp(url, username, password);
	
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
		
	HomePage homePage = new HomePage(driver);
	homePage.SignOut();
	
	}
	@AfterClass(alwaysRun = true)
	public void configAC() {
	driver.quit();
	}
	@AfterSuite(alwaysRun = true)
	public void configAS() {
	System.out.println(" Close DataBase ");
	
}
}
