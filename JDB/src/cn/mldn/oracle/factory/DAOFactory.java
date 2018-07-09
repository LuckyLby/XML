package cn.mldn.oracle.factory;
import java.sql.Connection;
import cn.mldn.oracle.dao.*;
import cn.mldn.oracle.dao.impl.*;
public class DAOFactory {
	public static IEmpDAO getIEmpDAOInstance(Connection conn) {
		 return new EmpDAOImpl(conn);
	}
}
