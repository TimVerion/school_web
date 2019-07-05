/**
 * 
 */
package cn.stuManger.teacher.service;

import java.sql.SQLException;

import cn.stuManger.teacher.dao.Dao;
import cn.stuManger.teacher.domain.Teacher;

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
	public Teacher findTea(String uid) throws SQLException {
		
		return dao.findTea(uid);
	}
}
