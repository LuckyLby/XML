package cn.mldn.oracle.dbc;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
public class DatabaseConnection {
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:mldn";
	private static final String DBUSER = "system";
	private static final String PASSWORD = "manager";
	private Connection conn = null;
	public DatabaseConnection() {
			try {
				Class.forName(DBDRIVER);
				this.conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	public Connection getConnection() {
		return this.conn;
	}
	public void close() {
		if(this.conn != null) {
			try {
				this.conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
