package practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	public static void main(String[] args) throws Exception {
		//fileInputStream belongs to java.io package and it is used to create java object representation of physical file
		FileInputStream fis= new FileInputStream("./data/commondata.property");
		
		Properties p=new Properties(); 
		p.load(fis);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		String browser=p.getProperty("browser");
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(un);
		System.out.println(pw);
		
	}
}
