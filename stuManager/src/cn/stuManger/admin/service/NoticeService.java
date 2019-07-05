/**
 * 
 */
package cn.stuManger.admin.service;

import java.sql.SQLException;
import java.util.List;



import cn.stuManger.admin.dao.NoticeDao;
import cn.stuManger.admin.domain.Notice;
import cn.stuManger.pager.PageBean;

/**
 * @date 2019年5月6日
 */
public class NoticeService {
	NoticeDao dao = new NoticeDao();
	//
	public PageBean<Notice> findAllNotice(int pd) throws SQLException{
		return dao.findAllNotice(null, pd);
	}
	public List<Notice> findAll() throws SQLException{
		return dao.findAll();
	}
	//增加
	public void add(Notice stu) throws SQLException{
		dao.add(stu);
	}
	//删除
	public void del(String ids) throws SQLException{
		dao.del(ids);
	}
}
