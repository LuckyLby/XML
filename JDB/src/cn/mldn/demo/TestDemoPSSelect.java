package cn.mldn.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
public class TestDemoPSSelect {
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:mldn";
	public static final String DBUSER = "system";
	public static final String PASSWORD = "manager";
	public static void main(String args[]) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Class.forName(DBDRIVER);
		String sql = "SELECT mid,name,age,birthday,note FROM member WHERE mid = ?";
		conn = DriverManager.getConnection(DBURL,DBUSER, PASSWORD);
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 3);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int mid = rs.getInt(1);
			String name = rs.getString(2);
			int age = rs.getInt(3);
			Date birthday = rs.getDate(4);
			String note = rs.getString(5);
			System.out.println(mid + "," + name + "," + age + "," + birthday + "," + note);
		}
		pstmt.close();
		conn.close();
	}
}
