/**
 * 
 */
package cn.stuManger.admin.service;

import java.sql.SQLException;
import java.util.List;




import cn.stuManger.admin.dao.AwardDao;
import cn.stuManger.admin.domain.Award;

/**
 * @date 2019��5��5��
 */
public class AwardService {
	AwardDao dao = new AwardDao();
	//ͨ�ò�ѯ
			public List<Award> findAll() throws SQLException{
				return dao.findAll();
			
			}
			//����
			public void add(Award stu) throws SQLException{
				dao.add(stu);
			}
			//ɾ��
			public void del(String ids) throws SQLException{
				dao.del(ids);
			}
			//�޸�
			public void update(Award stu) throws SQLException{
				dao.update(stu);
			}
			//�鿴
			public Award desc(String name) throws SQLException{
				return dao.desc(name);
			}
			//
			public Award findById(String id) throws SQLException{
				return dao.findById(id);
			}
}
