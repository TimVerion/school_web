/**
 * 
 */
package cn.stuManger.admin.service;

import java.sql.SQLException;

import cn.stuManger.admin.dao.JudgeDao;
import cn.stuManger.admin.domain.Judge;
import cn.stuManger.pager.PageBean;

/**
 * @date 2019��5��5��
 */
public class JudgeService {
	JudgeDao dao = new JudgeDao();
	public PageBean<Judge> findAllJudge(int pd) throws SQLException{
		return dao.findAllJudge(null, pd);
	}
	
	//�Խ�ѧ�����ɾ�Ĳ�
		//����
		public void add(Judge stu) throws SQLException{
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
		public Judge findJudge(String uid) throws SQLException {
			return dao.findJudge(uid);
		}
}
