package cn.mldn.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
public class TestDemoPS {
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:mldn";
	public static final String DBUSER = "system";
	public static final String PASSWORD = "manager";
	public static void main(String args[]) throws Exception {
		String name = "Mr'Smith";
		Date birthday = new Date();
		int age = 30;
		String  note = "www.mldnjava.cn";
		String sql = "INSERT INTO member(mid,name,age,birthday,note)" + 
		 "VALUES(myseq.nextval,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,name);
		pstmt.setInt(2,age);
		pstmt.setDate(3,new java.sql.Date(birthday.getTime()));
		pstmt.setString(4,note);
		int len = pstmt.executeUpdate();
		System.out.println("更新行数：" + len);
		pstmt.close();
		conn.close();
	}
}
