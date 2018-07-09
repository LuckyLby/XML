package cn.mldn.oracle.service;
import java.util.Map;
import cn.mldn.oracle.vo.Emp;
public interface IEmpService {
	/**
	 * 调用数据库的增加操作，操作如下：<br>
	 * <li>首先要使用IEmpDAO接口的findByid()方法，根据要增加的id查看知道的雇员信息是否存在
	 * <li>如果要增加的雇员信息不存在，则执行IEmpDAO接口的doCreate()方法，并将结果返回
	 * @param vo 包装数据的对象
	 * @return 如果增加成功，返回true，如果雇员存在或者增加失败，返回false
	 * @throws Exception 有异常交给被调用处处理
	 */
	public boolean insert(Emp vo) throws Exception;
	/**
	 * 执行数据的更新操作，操作时直接调用IEmpDAO结果的doUpdate()方法，并将更新结果返回
	 * @param vo包装数据的对象
	 * @return 如果修改成功，返回true，如果数据不存在或修改失败，返回false
	 * @throws Exception 有异常交给调用处处理
	 */
	public boolean update(Emp vo) throws Exception;
	/**
	 * 执行数据的删除操作，删除操作时调用IEmpDAO接口的doRemove()方法
	 * @param id 要删除雇员的id
	 * @return 如果删除成功返回true，如果雇员不存在或者删除失败返回false
	 * @throws Exception 有异常交给调用处处理
	 */
	public boolean delete(int id) throws Exception;
	/**
	 * 根据雇员的编号取得全部的
	 * @param id 雇员编号
	 * @return 如果雇员存在则将数据包装为Emp对象返回，如果数据不存在则返回false
	 * @throws Exxeption 有异常交给调用处处理
	 */
	public Emp get(int id) throws Exception;
	/**
	 * 查询全部或者模糊查询全部数据，查询的同时可以返回满足此查询的数据量，在调用时需要执行以下操作：<br>
	 * <li>查询全部的雇员信息：使用IEmpDAO接口的findAll（）方法操作
	 * <li>查询满足条件的雇员数量：使用IEmpDAO接口的getAllCount()方法操作
	 * @param column 模糊查询的字段
	 * @param keyWord 模糊查询的关键字
	 * @param currentPage 当前所在页
	 * @param lineSize 每页显示的数据长度
	 * @return 由于在进行数据返回时，此方法要返回两类数据:List<Emp>、int,使用Map返回：<br>
	 * <li>返回值1：key = allEmps, value = findAll();
	 * <li>返回值2：key = empCount， value = getAllCount();
	 * @throws Exception 有异常交给调用处处理
	 */
	public Map<String, Object> list(String column,String keyWord,int currentPage,int lineSize) throws Exception;
}

