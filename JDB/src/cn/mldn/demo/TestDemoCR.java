package cn.mldn.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
public class TestDemoCR {
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:mldn";
	public static final String DBUSER = "system";
	public static final String PASSWORD = "manager";
	public static void main(String args[]) throws Exception {
		Connection conn =null;
		Statement stmt = null;
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		stmt = conn.createStatement();
		conn.setAutoCommit(false);
		try {
			stmt.addBatch("INSERT INTO member(mid,name) VALUES(myseq.nextval,'张三A')");
			stmt.addBatch("INSERT INTO member(mid,name) VALUES(myseq.nextval,'张三B')");
			stmt.addBatch("INSERT INTO member(mid,name) VALUES(myseq.nextval,'张三'C')");
			stmt.addBatch("INSERT INTO member(mid,name) VALUES(myseq.nextval,'张三D')");
			stmt.addBatch("INSERT INTO member(mid,name) VALUES(myseq.nextval,'张三E')");
			int data[] = stmt.executeBatch();
			System.out.println(Arrays.toString(data));
			conn.commit();
		}catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}
		conn.close();
	}
}
