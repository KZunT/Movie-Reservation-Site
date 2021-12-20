package reservation.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			
			String url = "jdbc:mysql://localhost:3306/MovieDB";
			String user = "root";
			String password = "1234";

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		finally {
//			if (conn != null)
//				conn.close();
//		}
		
		return conn;
	}
	
}