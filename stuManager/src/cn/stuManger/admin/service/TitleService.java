/**
 * 
 */
package cn.stuManger.admin.service;

import java.sql.SQLException;

import cn.stuManger.admin.dao.TitleDao;
import cn.stuManger.admin.domain.Title;
import cn.stuManger.pager.PageBean;

/**
 * @date 2019年5月6日
 */
public class TitleService {
	TitleDao dao = new TitleDao();
	public PageBean<Title> findAll(int pd) throws SQLException{
		return dao.findAllTitle(null, pd);
	
	}
	//删除
	public void del(String ids) throws SQLException{
		dao.del(ids);
	}
	//增加
	/**
	 * @param stu
	 * @throws SQLException 
	 */
	public void add(Title stu) throws SQLException {
		dao.add(stu);
		
	}
	/**
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	public Title findTitle(String uid) throws SQLException {
		
		return dao.findTitle(uid);
	}
	
}
