/**
 * 
 */
package cn.stuManger.teacher.dao;

import java.sql.SQLException;




import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;




import cn.itcast.jdbc.TxQueryRunner;
import cn.stuManger.stu.domain.Student;
import cn.stuManger.teacher.domain.Teacher;
/**
 * @date 2019Äê5ÔÂ2ÈÕ
 */
public class Dao {
	private QueryRunner qr = new TxQueryRunner();
	//µÇÂ½
	public boolean login(String username,String pwd) throws SQLException{
		String sql = "select * from t_teacher where uid=? and pwd=?";
		Object[] param = {username,pwd};
		Student query = qr.query(sql, new BeanHandler<Student>(Student.class),param);
		if(query != null){
			return true;
		}
		return false;
		
	}
	/**
	 * @param username
	 * @param pwd
	 * @throws SQLException 
	 */
	/**
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	public Teacher findTea(String uid) throws SQLException {
		String sql = "select * from t_teacher where uid=?";
		return qr.query(sql, new BeanHandler<Teacher>(Teacher.class),uid);
	}
}
