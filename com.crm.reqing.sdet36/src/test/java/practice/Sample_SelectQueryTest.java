package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample_SelectQueryTest {

	public static void main(String[] args) throws Exception {
		Connection conn= null;
		int num=1;
		try {
		Driver sqldriver = new Driver();//creating object reference variable for jdbc database driver 
		//resistering to mysql
		DriverManager.registerDriver(sqldriver);// calling the resister method present inside DriverManager interface 
		//setting connection with mySql
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet36","root","root");

		//creating statement
		Statement stmt = conn.createStatement();
		//executing the select query
		ResultSet rs = stmt.executeQuery("select count(*) from information_schema.columns where table_name='student';");
		while(rs.next()) {
			int k= rs.getInt(1);
			num=k;
		System.out.println(num);
		}
		ResultSet result = stmt.executeQuery("select * from student;");


		//getting the data
		for(int i=0;i<=num;i++) {
		while(result.next()) {
			System.out.println(result.getInt(i)+" "+result.getString(++i)+" "+result.getString(++i)+" "+result.getString(++i));
		}
		}
		}
		catch(Exception e)
		{
			
		}
		finally {
			//close the connection
			conn.close();
		}
		
	}

}
