package com.crm.reqing.DataUpload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.reqing.loginTest.LoginTest;

public class FileLibTest {
	public static String url;
	public static String un ;
	public static String pw ;
	public static String browser;
	public static Workbook book;
	
	public void getPropertyData() throws Exception {
		FileInputStream fis= new FileInputStream("./data/commondata.property");
		Properties p=new Properties(); 
		p.load(fis);
		 url = p.getProperty("url");
		 un = p.getProperty("username");
		 pw = p.getProperty("password");
		 browser=p.getProperty("browser");
	}
	
	public void getexceldata() throws Exception {
		FileInputStream fis= new FileInputStream("./data/vtigerdata.xlsx");
		book=WorkbookFactory.create(fis);
	}

		
	
}
