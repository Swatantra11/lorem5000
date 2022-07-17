package practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetSystemDate {

	public static void main(String [] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   Object finalformate = dtf.format(now);
		   System.out.println(finalformate);
	}
}
