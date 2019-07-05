/**
 * 
 */
package cn.stuManger.admin.service;

import java.sql.SQLException;

import cn.stuManger.admin.dao.RecordDao;
import cn.stuManger.admin.domain.Record;
import cn.stuManger.pager.PageBean;

/**
 * @date 2019年5月6日
 */
public class RecordService {
	RecordDao dao = new RecordDao();
	public PageBean<Record> findAllRecord(int pd) throws SQLException{
		return dao.findAllRecord(null, pd);
	}
	
	//对奖学金的增删改查
		//增加
		public void add(Record stu) throws SQLException{
			dao.add(stu);
		}
		//删除
		public void del(String ids) throws SQLException{
			dao.del(ids);
		}

		/**
		 * @param uid
		 * @return
		 * @throws SQLException 
		 */
		public Record findRecord(String uid) throws SQLException {
			return dao.findRecord(uid);
		}
}
