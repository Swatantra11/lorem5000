package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.extractor.XSSFImportFromXML;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class ReadMultipleDataFromExcelfile {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("./data/exeldata.xlsx");
		Workbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheet("CreateOrg");
		short cellcount = sheet.getRow(1).getLastCellNum();
		
		int rowcount =sheet.getLastRowNum();
		System.out.println(rowcount);
		System.out.println(cellcount);
		
		
			for(int j=0;j<cellcount;j++) {
				for(int i=0;i<=rowcount;i++) {
				String data = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data);
			}
		}
		
	
		book.close();
	}

}
