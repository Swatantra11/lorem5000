package com.crm.reqing.GenericUtility;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


  
  
public class ListenerImplimentation  implements ITestListener{

	public void onTestFailure(ITestResult result) {
	
		String testname = result.getMethod().getMethodName();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		
		 String date = new Date().toString().replaceAll(":", "-");
		
		
		try {
			File dest = new File("./screenshot/"+testname+date+".PNG");
			FileUtils.copyFile(src, dest);
		}
		catch(Exception e) {
		System.out.println(" Screen shot not taken ");	
		}
		
	}

}
