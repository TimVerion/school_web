/**
 * 
 */
package cn.stuManger.admin.service;

import java.sql.SQLException;
import java.util.List;




import cn.stuManger.admin.dao.AwardDao;
import cn.stuManger.admin.domain.Award;

/**
 * @date 2019年5月5日
 */
public class AwardService {
	AwardDao dao = new AwardDao();
	//通用查询
			public List<Award> findAll() throws SQLException{
				return dao.findAll();
			
			}
			//增加
			public void add(Award stu) throws SQLException{
				dao.add(stu);
			}
			//删除
			public void del(String ids) throws SQLException{
				dao.del(ids);
			}
			//修改
			public void update(Award stu) throws SQLException{
				dao.update(stu);
			}
			//查看
			public Award desc(String name) throws SQLException{
				return dao.desc(name);
			}
			//
			public Award findById(String id) throws SQLException{
				return dao.findById(id);
			}
}
