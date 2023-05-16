package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이브 로드 성공");
		String id = "ysj0947", pwd = "1598";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		Connection con = DriverManager.getConnection(url, id, pwd);
		return con;
	}
}
