package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelCheckDataTest {

	public static void main(String[] args) throws Exception {
		int r=1
				;
		int c=2;
		String expectedname="TY_ORG";
		
		FileInputStream fis = new FileInputStream("./data/exeldata.xlsx");
		Workbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheet("CreateOrg");
		
				String actualname = sheet.getRow(r).getCell(c).getStringCellValue();
				if(expectedname.equals(actualname)) {
					
					String data = sheet.getRow(r).getCell(++c).getStringCellValue();
					System.out.println(data);
				}
					
		
	
		book.close();
	}

	

}
