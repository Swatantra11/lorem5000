package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VtigerLoginTest {
	public static WebDriver driver;
	public static void main(String[] args) throws Exception {


		FileInputStream fis= new FileInputStream("./data/commondata.property");
		Properties p=new Properties(); 
		p.load(fis);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();

	
		
		CreateOrganizationTest cot =new CreateOrganizationTest();
		cot.createorganization();
		
		Actions a=  new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[text()='More']"))).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		
		CreateNewCampainsTest c= new CreateNewCampainsTest();
		c.newCampain();


		
	}
}
