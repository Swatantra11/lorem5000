package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ProjectUnitTest {
	public static void main(String[] args) throws Exception {
		String name= "Swatantra";
		Connection conn = null;
		try {
			Driver sqldriver = new Driver();
			DriverManager.registerDriver(sqldriver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet36","root","root");

			Statement stmt = conn.createStatement();

			stmt.executeUpdate("insert into student (regno, firstName, middleName, lastName) values('7', 'Swatantra','Singh', 'h')");
			ResultSet result = stmt.executeQuery("select * from student;");

			System.out.println(" After inserting the data ");

			boolean rs;
			//getting the data
			while(result.next()) {
				String actname=result.getString(2);
				if(actname.equals(name)) {
					System.out.println(" Test is passed");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(" Exception is handled ");
			e.printStackTrace();
		}


		try {
			Driver sqldriver = new Driver();
			DriverManager.registerDriver(sqldriver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet36","root","root");

			Statement stmt = conn.createStatement();

			stmt.executeUpdate("delete from student where regno = 7");
			ResultSet result = stmt.executeQuery("select * from student;");

			System.out.println();
			System.out.println(" After deleting the data ");

			//getting the data
			while(result.next()) {

				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			}
		}
		catch(Exception e)
		{
			System.out.println(" Exception is handled ");
			e.printStackTrace();

		}
		finally {
			conn.close();
		}
	}


}
