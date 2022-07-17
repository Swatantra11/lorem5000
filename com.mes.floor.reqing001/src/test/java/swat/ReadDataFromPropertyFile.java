package swat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	public static void main(String[] args) throws Exception {
		FileInputStream fis= new FileInputStream("./target/commondata.property");
		Properties p=new Properties(); 
		p.load(fis);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		
		System.out.println(url);
		System.out.println(un);
		System.out.println(pw);
	}

}

