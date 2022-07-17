package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class ReadDataFromExcelfile {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("./data/exeldata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String data = book.getSheet("CreateOrg").getRow(1).getCell(2).getStringCellValue();
		System.out.println("organization name is :"+data);
		

	}

}
