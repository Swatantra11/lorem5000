package practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadNumericalDataExcelTest {

	public static void main(String[] args) throws Exception {
		FileInputStream fis =new FileInputStream("./data/vtigerdata.xlsx");
		Workbook wb = new XSSFWorkbook(fis);
		DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
		Cell cell = wb.getSheet("contacts").getRow(1).getCell(1);//getting the cell value in Integer form
		//Returns the formatted value of a cell as a String regardless of the cell type.		
		String number = formatter.formatCellValue(cell);
		System.out.println(number);
	        
	
		

	}

}
