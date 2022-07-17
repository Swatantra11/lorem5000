package com.crm.reqing.OrganizationsTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreatOrganizationWithMemberOfTest {
	public static void main(String[] args) throws IOException, Exception {

		//FileInputStream is java representational object of physical file
		FileInputStream fis=new FileInputStream("./data/vtiger.properties");
		Properties p= new Properties();
		p.load(fis);
		String browser=p.getProperty("Browser");
		String url = p.getProperty("url");
		String un  =p.getProperty("un");
		String pwd =p.getProperty("pwd");
		String lastname=p.getProperty("lastname");
		String organizationName=p.getProperty("organizationName");

		WebDriver driver =new ChromeDriver();
		Random ran=new Random();
		int num = ran.nextInt();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath(("(//a[text()='Organizations'])[1]"))).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(organizationName +num);


		//click on mamberof lookup button
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		//integrate with memberof module

		String pw = driver.getWindowHandle();
		System.out.println(pw);
		String pt = driver.getTitle();
		Set<String> set = driver.getWindowHandles();

		Iterator<String> it= set.iterator(); 

		while(it.hasNext()) {
			String	wind=it.next();
			driver.switchTo().window(wind);
//			String title = driver.getTitle();
//			System.out.println(wind);
//			if(pw.contains(wind))
//			{
//				break;
//
//			}
		}
		System.out.println("Child window opened");
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("TYSS");
		System.out.println("Enter organization name");
		driver.findElement(By.xpath("//input[@name=\"search\"]")).click();

		//to move control to the alert popup
	Thread.sleep(4000);
		driver.findElement(By.id("1")).click();

		//handle popup here
		try {
			Alert a=driver.switchTo().alert();
			a.accept();
		}
		catch(Exception e) {
			System.out.println("alert exception");
		}

		System.out.println("Memberof done");
Thread.sleep(4000);

		Set<String> set2 = driver.getWindowHandles();
		Iterator<String> it1= set2.iterator(); 

		while(it1.hasNext()) {
			String	wind=it1.next();
			driver.switchTo().window(wind);
			String title = driver.getTitle();
			System.out.println(title);
			if(title.contains(pw))
			{
				break;
			}


			//			driver.switchTo().defaultContent();
			System.out.println("parent window opened");
			driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();


			System.out.println("Succesfully saved");

			Thread.sleep(5000);

			String actualdata = driver.findElement(By.className("dvHeaderText")).getText();
			if (actualdata.contains("TYSS"))
			{
				System.out.println("organization is created succesfully");
			}

			//signout from the page
			WebElement Resource = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions ac=new Actions(driver);
			ac.moveToElement(Resource).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			System.out.println("succesfully done");

			driver.close();

		}
	}
}
