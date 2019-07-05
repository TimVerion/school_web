/**
 * 
 */
package cn.stuManger.admin.service;

import java.sql.SQLException;

import cn.stuManger.admin.dao.RecordDao;
import cn.stuManger.admin.domain.Record;
import cn.stuManger.pager.PageBean;

/**
 * @date 2019��5��6��
 */
public class RecordService {
	RecordDao dao = new RecordDao();
	public PageBean<Record> findAllRecord(int pd) throws SQLException{
		return dao.findAllRecord(null, pd);
	}
	
	//�Խ�ѧ�����ɾ�Ĳ�
		//����
		public void add(Record stu) throws SQLException{
			dao.add(stu);
		}
		//ɾ��
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
