package swat;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class mySqlDataFetch {
	public static void main(String[] args) throws SQLException, Exception {

		Class.forName("com.mysql.jdbc.Driver");
		
		FileInputStream fis = new FileInputStream("./target/mysql.property");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		
		System.out.println(url);
		System.out.println(pw);
		System.out.println(pw);

		Connection conn = DriverManager.getConnection(url,un,pw);
		java.sql.Statement stmt = conn.createStatement();
		String sql = "SELECT * " +
				"FROM student";

		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
	}
}
