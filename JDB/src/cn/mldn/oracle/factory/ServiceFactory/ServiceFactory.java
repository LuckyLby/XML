package cn.mldn.oracle.factory.ServiceFactory;
import cn.mldn.oracle.service.IEmpService;
import cn.mldn.oracle.service.impl.EmpServiceImpl;;
public class ServiceFactory {
	public static IEmpService getIEmpServiceImpl() {
		return new EmpServiceImpl();
	}
}
