package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationTest extends VtigerLoginTest {
public void createorganization() {
	
	JavascriptExecutor j= (JavascriptExecutor)driver;
	
	
	
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys("Test Yantra");
	driver.findElement(By.name("website")).sendKeys("https://www.testyantra.com/");
	driver.findElement(By.id("tickersymbol")).sendKeys("TYSS");
	
	driver.findElement(By.id("employees")).sendKeys("5000");
	driver.findElement(By.id("email2")).sendKeys("contactus@testyantra.com");
	driver.findElement(By.id("email1")).sendKeys("contactus@testyantra.com");
	driver.findElement(By.id("phone")).sendKeys("9742490958");
	driver.findElement(By.id("fax")).sendKeys("tyss.fcx");
	driver.findElement(By.id("otherphone")).sendKeys("9742490958");
	driver.findElement(By.id("ownership")).sendKeys("Global");
	WebElement annual_revenue = driver.findElement(By.name("annual_revenue"));
	annual_revenue.clear();
	annual_revenue.sendKeys("1000");
	driver.findElement(By.id("siccode")).sendKeys("tyss23231");
	
	WebElement industrylist = driver.findElement(By.name("industry"));
	Select s1= new Select(industrylist);
	s1.selectByIndex(2);
	WebElement accounttype = driver.findElement(By.name("accounttype"));
	Select s2= new Select(accounttype);
	s2.selectByIndex(2);
	WebElement ratinglist = driver.findElement(By.name("rating"));
	Select s3= new Select(ratinglist);
	s3.selectByIndex(2);
	driver.findElement(By.name("notify_owner")).click();
	driver.findElement(By.name("emailoptout")).click();
	
	driver.findElement(By.name("bill_street")).sendKeys(" #88, 3rd Floor, Brigade Chambers,"
			+ " "
			+ "Gandhi Bazaar Main Rd, Basavanagudi, Bangalore-560004 Karnataka, India");
	
	driver.findElement(By.id("bill_pobox")).sendKeys("560076");
	driver.findElement(By.id("bill_city")).sendKeys("Bengaluru");
	driver.findElement(By.id("bill_state")).sendKeys("Karanataka");
	driver.findElement(By.id("bill_code")).sendKeys("560004");
	driver.findElement(By.id("bill_country")).sendKeys("India");
	driver.findElement(By.xpath("//input[@onclick='return copyAddressRight(EditView)']")).click();
	
	driver.findElement(By.name("description")).sendKeys(" I am checking");
	
	//driver.findElement(By.className("crmbutton small save")).click();
	
	
	
}
}
