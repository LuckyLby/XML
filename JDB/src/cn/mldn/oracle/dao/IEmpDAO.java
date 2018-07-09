package cn.mldn.oracle.dao;
import java.util.List;
import cn.mldn.oracle.vo.Emp;
/**
 * 
 * @author AR
 *公共的DAO操作接口
 * @param <K>要操作的数据表的主键类型
 * @param <V>要操作的VO类型
 */
public interface IEmpDAO {
	/**
	 * 执行数据的增加操作
	 * @param vo 包含所要增加的数据的VO对象
	 * @return 如果增加数据成功返回true，反之false
	 * @throws Exception 操作中出现了异常，返回给调用处执行处理
	 */
	public boolean doCreate(Emp vo) throws Exception;
	/**
	 * 执数据的更新操作
	 * @param vo 包含了新数据的VO对象
	 * @return 如果删除成功返回true，反之false
	 * @throws Exception Exception 操作中出现了异常，返回给调用处执行处理
	 */
	public boolean doUpdate(Emp vo) throws Exception;
	/**
	 * 删除一个雇员的信息
	 * @param vo 要删除雇员的编号
	 * @return 如果没有指定的雇员编号，返回值为null
	 * @throws Exception Exception 操作中出现了异常，返回给调用处执行处理
	 */
	public boolean doRemove(int id) throws Exception;
	/**
	 * 根据雇员编号查询一个雇员的完整信息
	 * @param id 要查询雇员的编号
	 * @return 如果没有指定的雇员编号，返回值为null，<br/>
	 * 如果有指定的雇员信息，则将所有的信息包装到Emp实例对象中返回
	 * @throws Exception Exception 操作中出现了异常，返回给调用处执行处理
	 */
	public Emp findByid(int id)throws Exception;
	/**
	 * 查询全部的雇员信息
	 * @return 多个雇员信息使用List返回，如果List集合的size()长度为0，则没有数据返回
	 * @throws Exception 操作中出现了异常，返回给调用处执行处理
	 */
	public List<Emp>findAll()throws Exception;
	/**
	 * 分页显示所有的雇员信息，同时完成模糊查询
	 * @param column 要模糊查询的字段名称
	 * @param keyWord 要模糊查询的数据，如果为空字符串则表示查询全部
	 * @param currentPage 当前所在的页
	 * @param lineSize 每页显示的记录长度
	 * @return 多个雇员信息使用List返回，如果List集合的size()长度为0，则没有数据返回
	 * @throws Exception 操作中出现了异常，返回给调用处执行处理
	 */
	public List<Emp>findALL(String column,String keyWord,int currentPage,int lineSize)throws Exception;
	/**
	 * 统计模糊查询的数据结果，使用COUNT（）函数进行统计
	 * @param column 要模糊查询的字段名称
	 * @param keyWord 要模糊查询的数据，如果为空字符串则表示查询全部
	 * @return 会根据数据量的多少返回数据的长度，如果没有返回0
	 * @throws Exception 出现了异常，返回给调用处执行处理
	 */
	public int getAllCount(String column,String keyWord)throws Exception;
}
