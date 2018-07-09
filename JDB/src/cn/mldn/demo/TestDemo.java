package cn.mldn.demo;
import java.sql.Connection;
import java.sql.DriverManager;
public class TestDemo {
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:mldn";
	public static final String DBUSER = "system";
	public static final String PASSWORD = "manager";
	public static void main(String args[]) throws Exception {
		Connection conn = null;
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
		System.out.println(conn);
		conn.close();
	}
}
