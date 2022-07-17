  package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.reqing.GenericUtility.ExcelUtility;

public class BookTicketTest1 {

	@Test(dataProvider = "DataProviderTest_forTicket")
	public void BookTicketTestTest(String source , String destination,String tickets) {
		System.out.println(" Book "+tickets+" tickets from "+source+" to "+destination);
	}
@DataProvider
	public Object[][] DataProviderTest_forTicket() throws Throwable {
ExcelUtility eLib=new  ExcelUtility();
		Object [][] location=new Object[5][3];
		int m=1;
		for(int i=0;i<5;i++) {
			int n=0;
			for(int j=0;j<3;j++) {
				location[i][j]=eLib.getDataFromExcel("dataprovider", m, n);
				n++;
				
			}
			m++;
			
		}

		return location;

	}

}
