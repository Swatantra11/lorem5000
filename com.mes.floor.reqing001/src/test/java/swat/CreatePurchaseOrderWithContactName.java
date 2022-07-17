package swat;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreatePurchaseOrderWithContactName {

	public static void main(String[] args) throws Exception {
//		FileLibTest pfile = new FileLibTest();
//		pfile.getPropertyData("url");
//		pfile.getexceldata();
		

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(" login ");
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		Actions a=  new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[text()='More']"))).perform();
		//a.moveToElement(driver.findElement(By.xpath("//a[text()='More']"))).perform();
		driver.findElement(By.partialLinkText("Purchase Order")).click();
		driver.findElement(By.xpath("//img[@alt='Create Purchase Order...']")).click();
		String urrentTitle = driver.getTitle();
		System.out.println(urrentTitle);
		driver.findElement(By.xpath("//input[@name='contact_name']/../img")).click();
		

		Set<String> allwh = driver.getWindowHandles();
		
		Iterator<String> it =allwh.iterator();
		
		
		while(it.hasNext()){
			String wh = it.next();
			driver.switchTo().window(wh);
			String currentTitle = driver.getTitle();
			System.out.println(currentTitle);
			if(currentTitle.contains(urrentTitle)) {
				continue;
			}
		}
		
		
		driver.findElement(By.id("search_txt")).sendKeys("hii");
		
Set<String> all = driver.getWindowHandles();
		
		Iterator<String> it1 =all.iterator();
		while(it1.hasNext()){
			String wh = it1.next();
			driver.switchTo().window(wh);
			String currentTitle = driver.getTitle();
			System.out.println(currentTitle);
			if(currentTitle.contains(urrentTitle)) {
				break;
			}
		}
		
		driver.findElement(By.name("subject")).sendKeys("seee");
		}

}
