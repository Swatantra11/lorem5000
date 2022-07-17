package com.crm.reqing.SampleTest;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.crm.reqing.GenericUtility.ListenerImplimentation.class)
public class SampleScreenShotTest{

@Test
	public void ScreenShotTest() throws Exception {
	WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:8888");
	TakesScreenshot t= (TakesScreenshot)driver;
	
	File src = t.getScreenshotAs(OutputType.FILE);
	
	try {
		File dest = new File("./screenshot/ss.PNG");
		FileUtils.copyFile(src, dest);
	}
	catch(Exception e) {
		System.out.println(" Screen shot not taken ");	
		}

	
	}
	@Test
	public void ScreenShotByEventFiringTest() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try {
			File dest = new File("./screenshot/pp.PNG");
			FileUtils.copyFile(src, dest);
		}
		catch(Exception e) {
		System.out.println(" Screen shot not taken ");	
		}
		
	
		}
	
}
