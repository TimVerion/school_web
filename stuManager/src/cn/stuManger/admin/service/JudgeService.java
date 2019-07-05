/**
 * 
 */
package cn.stuManger.admin.service;

import java.sql.SQLException;

import cn.stuManger.admin.dao.JudgeDao;
import cn.stuManger.admin.domain.Judge;
import cn.stuManger.pager.PageBean;

/**
 * @date 2019年5月5日
 */
public class JudgeService {
	JudgeDao dao = new JudgeDao();
	public PageBean<Judge> findAllJudge(int pd) throws SQLException{
		return dao.findAllJudge(null, pd);
	}
	
	//对奖学金的增删改查
		//增加
		public void add(Judge stu) throws SQLException{
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
		public Judge findJudge(String uid) throws SQLException {
			return dao.findJudge(uid);
		}
}
