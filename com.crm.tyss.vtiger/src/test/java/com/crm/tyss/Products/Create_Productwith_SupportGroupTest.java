package com.crm.tyss.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.crm.tyss.generic.MainClass;

public class Create_Productwith_SupportGroupTest extends MainClass {
	public void CreateProductwithSupportGroup() {
		String productname=wb.getSheet("product").getRow(7).getCell(0).getStringCellValue();
		WebElement quickList = driver.findElement(By.id("qccombo"));
		Select sq= new Select(quickList);
		sq.selectByVisibleText("New Product");
		
		driver.findElement(By.name("productname")).sendKeys(productname);

		driver.findElement(By.xpath("//input[@value='T']")).click();
		
		WebElement groupList = driver.findElement(By.name("assigned_group_id"));
		Select sg= new Select(groupList);
		sg.selectByVisibleText("Support Group");
		driver.findElement(By.name("button")).click();
		
		String text = driver.findElement(By.className("lvtHeaderText")).getText();
		if(text.contains(productname)) {
			System.out.println(" Productwith_SupportGroup pass ");
		}
		else {
			System.out.println(" Productwith_SupportGroup test fail ");
		}
	}
}
