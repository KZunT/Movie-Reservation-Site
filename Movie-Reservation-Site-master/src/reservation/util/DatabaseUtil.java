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
			// �ؽ�Ʈ ���Ͽ��� �� �پ� �����ͺ��̽� ���̵�, ��й�ȣ�� �Է��Ͽ� �����մϴ�.
//	        BufferedReader in = new BufferedReader(new FileReader(ServerUtil.authenticationPath + "Database.txt"));
//			String dbURL = "jdbc:mysql://localhost:3306/" + in.readLine() + "?useSSL=false&useUnicode=true";
//			String dbID = in.readLine();
//			String dbPassword = in.readLine();
//			in.close();
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
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