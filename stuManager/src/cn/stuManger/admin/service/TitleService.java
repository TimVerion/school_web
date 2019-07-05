/**
 * 
 */
package cn.stuManger.admin.service;

import java.sql.SQLException;

import cn.stuManger.admin.dao.TitleDao;
import cn.stuManger.admin.domain.Title;
import cn.stuManger.pager.PageBean;

/**
 * @date 2019��5��6��
 */
public class TitleService {
	TitleDao dao = new TitleDao();
	public PageBean<Title> findAll(int pd) throws SQLException{
		return dao.findAllTitle(null, pd);
	
	}
	//ɾ��
	public void del(String ids) throws SQLException{
		dao.del(ids);
	}
	//����
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
