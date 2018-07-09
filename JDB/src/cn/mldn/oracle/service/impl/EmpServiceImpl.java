package cn.mldn.oracle.service.impl;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import cn.mldn.oracle.dao.IEmpDAO;
import cn.mldn.oracle.dbc.DatabaseConnection;
import cn.mldn.oracle.factory.*;
import cn.mldn.oracle.service.*;
import cn.mldn.oracle.vo.*;
public class EmpServiceImpl implements IEmpService{
	private DatabaseConnection dbc = new DatabaseConnection();

	@Override
	public boolean insert(Emp vo) throws Exception {
		try {
			Connection conn = this.dbc.getConnection();
			IEmpDAO dao = DAOFactory.getIEmpDAOInstance(conn);//取得DAO接口对象
			if(dao.findByid(vo.getEmpno())==null) { //如果没有要查询的雇员对象
				return dao.doCreate(vo);	//返回DAO的结果
			}
			return false;
		}catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean update(Emp vo) throws Exception {
		try {
			return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).doUpdate(vo);
		}catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean delete(int id) throws Exception {
		try {
			return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).doRemove(id);
		}catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public Emp get(int id) throws Exception {
		try {
			return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).findByid(id);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception {
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("allEmaps", 
						DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).findALL(column, keyWord, currentPage, lineSize));
			map.put("empCount", DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).getAllCount(column, keyWord));
			return map;
		}catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}
}
