package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicketTest {

@Test(dataProvider = "DataProviderTest_forTicket")
	public void BookTicketTestTest(String source , String destination) {
		System.out.println(" Book ticket from "+source+" to "+destination);
	}
@DataProvider
	public Object[][] DataProviderTest_forTicket() {

		Object [][] location=new Object[5][2];
		
		location[0][0]= "Banglore";
		location[0][1]= "Melburne";

		location[1][0]="Banglore";
		location[1][1]="Sydny";

		location[2][0]="Banglore";
		location[2][1]="Singapore";

		location[3][0]="Banglore";
		location[3][1]="Paris";

		location[4][0]="Banglore";
		location[4][1]= "Mars";

		return location;

	}


}
