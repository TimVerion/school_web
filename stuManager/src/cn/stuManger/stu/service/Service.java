/**
 * 
 */
package cn.stuManger.stu.service;

import java.sql.SQLException;

import cn.stuManger.stu.dao.Dao;
import cn.stuManger.stu.domain.Student;

/**
 * @date 2019Äê5ÔÂ2ÈÕ
 */
public class Service {
	Dao dao = new Dao();
	public boolean login(String username,String pwd) throws SQLException{
		return dao.login(username, pwd);
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
	public Student findStu(String uid) throws SQLException {
		return dao.findStu(uid);
	}
}
