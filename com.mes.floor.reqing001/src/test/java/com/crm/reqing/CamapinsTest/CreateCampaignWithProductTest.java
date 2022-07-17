package com.crm.reqing.CamapinsTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

public class CreateCampaignWithProductTest extends CreateCampainsTest {
	String title=wb.getSheet("product").getRow(1).getCell(2).getStringCellValue();
	CreateCampainsTest c=new CreateCampainsTest();
	String name=c.pname;
	
public void productlookup() throws Exception{
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	String whp=driver.getWindowHandle();
	Set<String> allwh = driver.getWindowHandles();
	
	Iterator<String> it = allwh.iterator();
	
while(it.hasNext()) {
	String wh = it.next();
	driver.switchTo().window(wh);
	String currentTitle = driver.getTitle();
	if(currentTitle.equals(title)) {
		continue;
	}
}

	driver.findElement(By.className("txtBox")).sendKeys(name);
	driver.findElement(By.name("search")).click();
	
	driver.findElement(By.id("1")).click();
	
	Set<String> allwha = driver.getWindowHandles();
	it = allwha .iterator();
	while(it.hasNext()) {
		String wh = it.next();
		driver.switchTo().window(wh);
		String currentTitle = driver.getTitle();
		if(currentTitle.contains(title)) 
			break;
		
	}
	
}
}
