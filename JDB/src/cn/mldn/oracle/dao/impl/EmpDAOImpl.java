package cn.mldn.oracle.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cn.mldn.oracle.dao.IEmpDAO;
import cn.mldn.oracle.vo.Emp;
public class EmpDAOImpl implements IEmpDAO{
	private Connection conn;
	private PreparedStatement pstmt;
	public EmpDAOImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Emp vo) throws Exception {
		String sql = "INSERT INTO emp (emppno,ename,jod,hiredate,sal,comm) VALUES "
				+ "(?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,vo.getEmpno());
		this.pstmt.setString(2,vo.getEname());
		this.pstmt.setString(3, vo.getJob());
		this.pstmt.setDate(4,new java.sql.Date(vo.getHiredate().getTime()));
		this.pstmt.setDouble(5,vo.getSal());
		this.pstmt.setDouble(6, vo.getComm());
		if(this.pstmt.executeUpdate()>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean doUpdate(Emp vo) throws Exception {
		String sql = "UPDATE emp SET ename=?,jod=?,hiredate=?,sal=?,comm=? WHERE empno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getEname());
		this.pstmt.setString(2,vo.getJob());
		this.pstmt.setDate(3, new java.sql.Date(vo.getHiredate().getTime()));
		this.pstmt.setDouble(4, vo.getSal());
		this.pstmt.setDouble(5,vo.getComm());
		this.pstmt.setInt(6, vo.getEmpno());
		if(this.pstmt.executeUpdate()>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean doRemove(int id) throws Exception {
		String sql = "DELETE FROM emp WHERE empno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		if(this.pstmt.executeUpdate()>0) {
			return true;
		}
		return false;
	}

	@Override
	public Emp findByid(int id) throws Exception {
		Emp emp = null;
		String sql = "SELECT empno,ename,job,hiredate,sal,comm FROM emp WHERE empno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()) {
			emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setHiredate(rs.getDate(4));
			emp.setSal(rs.getDouble(5));
			emp.setComm(rs.getDouble(6));
		}
		return emp;
	}

	@Override
	public List<Emp> findAll() throws Exception {
		List<Emp> all = new ArrayList<Emp>();
		String sql = "SELECT empno,ename,job,hiredate,sal,comm FROM emp";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setHiredate(rs.getDate(4));
			emp.setSal(rs.getDouble(5));
			emp.setComm(rs.getDouble(6));
			all.add(emp);
		}
		return all;
	}

	@Override
	public List<Emp> findALL(String column, String keyWord, int currentPage, int lineSize) throws Exception {
		List<Emp> all = new ArrayList<Emp>();
		String sql = "SELECT * FROM ("
				+ "SELECT empno,ename,job,hiredate,sal,comm,ROWNUM rm FROM emp WHERE"
				+ column + "LIKE ? AND ROWNUM<=?)" + "WHERE tmp.rn>?";
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1,"%" + keyWord + "%");
				this.pstmt.setInt(2, currentPage*lineSize);
				this.pstmt.setInt(3, (currentPage-1)*lineSize);
				ResultSet rs = this.pstmt.executeQuery();
				while(rs.next()) {
					Emp emp = new Emp();
					emp.setEmpno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setHiredate(rs.getDate(4));
					emp.setSal(rs.getDouble(5));
					emp.setComm(rs.getDouble(6));
					all.add(emp);
				}
		return all;
	}

	@Override
	public int getAllCount(String column, String keyWord) throws Exception {
		String sql = "SELECT COUNT(empno) FROM emp WHERE " + column + "LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord +  "%");
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}
	
}
