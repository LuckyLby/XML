package cn.mldn.demo;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
public class TestDemoUpdate {
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:mldn";
	public static final String DBUSER = "system";
	public static final String PASSWORD = "manager";
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		stmt = conn.createStatement();
		String sql = "UPDATE member SET name = '李四',age=17,note = '摸了科技'" + "WHERE mid = 1";
		int len = stmt.executeUpdate(sql);
		System.out.println(len);
		stmt.close();
		conn.close();
	}
}
