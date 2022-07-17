package com.crm.reqing.POMReposatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.reqing.GenericUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{
	public WebDriver driver;

	public  LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(name="user_name")
	private WebElement userNameEdt;
	@FindBy (name ="user_password")
	private WebElement userpasswordedt;
	@FindBy(id="submitButton") 
	private WebElement loginBtn;


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getUserNameEdt() {
		return userNameEdt;
	}


	public WebElement getUserpasswordedt() {
		return userpasswordedt;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}


	public void loginToApp(String url,String userName, String password)
	{
		driver.get(url);
		waitForElementInDOM(driver);
		userNameEdt.sendKeys(userName);
		userpasswordedt.sendKeys(password);
		loginBtn.click();
	}
}
