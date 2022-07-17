package com.crm.tyss.GenericUtility;

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

import com.crm.tyss.POMReposatory.HomePage;
import com.crm.tyss.POMReposatory.LoginPage;


public class BaseClass {
	public WebDriver driver;
	//Object Creation for Lib
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtiltiy fLib = new FileUtiltiy();
	public ExcelUtility eLib = new ExcelUtility();
	
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS()
	{
		System.out.println(" CONNECT TO DATABASE ");
	}
	
	
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws Throwable {
	System.out.println(" LAUNCH THE BROWSER ");
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
	wLib.waitForElementInDOM(driver);
	driver.manage().window().maximize();

	
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable
	{
	
	String username =fLib.getPropertyKeyValue("username");
	String password = fLib.getPropertyKeyValue("password");
	String url = fLib.getPropertyKeyValue("url");	
	LoginPage login =new LoginPage(driver);
	login.loginToApp(url, username, password);
	
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM()
	{
	HomePage homePage = new HomePage(driver);
	homePage.SignOut();
	}
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {
	driver.quit();
	}
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() {
	System.out.println("=close DB=");
}
}
