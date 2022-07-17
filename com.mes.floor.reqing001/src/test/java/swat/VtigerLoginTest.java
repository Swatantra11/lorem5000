package swat;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VtigerLoginTest {

	
	public static void main(String[] args) throws IOException, Exception {
		FileInputStream fis= new FileInputStream("./data/commondata.property");
		Properties p=new Properties(); 
		p.load(fis);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(5000);
		
		Actions a=  new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[text()='More']"))).perform();
		driver.findElement(By.name("Campaigns")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		
		
		
		
		driver.close();
	}
}
