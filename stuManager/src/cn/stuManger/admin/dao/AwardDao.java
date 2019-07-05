/**

 * 
 */
package cn.stuManger.admin.dao;
import java.sql.SQLException;
import java.util.List;

import cn.stuManger.admin.domain.Award;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;

/**
 * @date 2019��5��5��
 */
public class AwardDao {
	QueryRunner qr = new TxQueryRunner();
	//ͨ�ò�ѯ
		public List<Award> findAll() throws SQLException{
			String sql="select * from  t_award";
			return qr.query(sql, new BeanListHandler<Award>(Award.class));
		
		}
		//����
		public void add(Award stu) throws SQLException{
			String sql = "insert into t_award values(null,?,?,?,?)";
			Object[] param = {stu.getName(),stu.getLevel(),stu.getPrice(),stu.getPubtime()};
			qr.update(sql, param);
		}
		//ɾ��
		public void del(String ids) throws SQLException{
			String sql = "delete from t_award where id in(?)";
			qr.update(sql,ids);
		}
		//�޸�
		public void update(Award stu) throws SQLException{
			String sql = "update t_award set name=?,level=?,price=?,pubtime=? where id=?";
			Object[] param = {stu.getName(),stu.getLevel(),stu.getPrice(),stu.getPubtime(),stu.getId()};
			qr.update(sql,param);
		}
		//�鿴
		public Award desc(String name) throws SQLException{
			String sql = "select * from t_award s where s.name=?";
			return qr.query(sql, new BeanHandler<Award>(Award.class),name);
		}
		//
		public Award findById(String id) throws SQLException{
			String sql = "select * from t_award s where s.id=?";
			return qr.query(sql, new BeanHandler<Award>(Award.class),id);
		}
}
