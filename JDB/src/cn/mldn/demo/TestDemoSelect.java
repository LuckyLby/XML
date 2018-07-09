package cn.mldn.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
public class TestDemoSelect {
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:mldn";
	public static final String DBUSER = "system";
	public static final String PASSWORD = "manager";
	public static void main(String args[]) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		stmt = conn.createStatement();
		String sql = "SELECT mid,name,age,birthday,note FROM member";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int mid = rs.getInt("mid");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			Date birthday = rs.getDate("birthday");
			String note = rs.getString("note");
			System.out.println(mid + "," + name + "," + age + "," + birthday + "," + note );
			
		}
		rs.close();
		conn.close();
	}
}
