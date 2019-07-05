/**
 * 
 */
package cn.stuManger.admin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.stuManger.admin.domain.Record;
import cn.stuManger.pager.Expression;
import cn.stuManger.pager.PageBean;
import cn.stuManger.pager.PageConstants;

/**
 * @date 2019��5��6��
 */
public class RecordDao {
	QueryRunner qr = new TxQueryRunner();
	public PageBean<Record> findAllRecord(List<Expression> exprList,int pd) throws SQLException{
		//�õ�ps
		int ps = PageConstants.BOOK_PAGE_SIZE;//ÿҳ��¼��
		//ͨ��exprList������where�Ӿ�
		StringBuilder whereSql = new StringBuilder(" where 1=1");
		List<Object> params = new ArrayList<Object>();
		if(exprList!=null){
			for(Expression expr:exprList){
				/*
				 * 1.��and��ͷ
				 * 2.����������
				 * 3.�����������
				 * 4.�����������isnull����׷�ӣ�����params����Ӷ�Ӧ��ֵ
				 */
				whereSql.append(" and ").append(expr.getName()).append(" ")
				.append(expr.getOperator()).append(" ");
				if(!expr.getOperator().equals("is null")){
					whereSql.append("?");
					params.add(expr.getValue());
				}
			}
			
		}
		//�ܼ�¼��
		String sql = "select count(*) from t_record"+whereSql;
		Number number = (Number)qr.query(sql,new ScalarHandler(),params.toArray());
		int tr = number.intValue();
		//�õ�beanList,����ǰҳ��¼
		sql = "select * from t_record s"+whereSql+" limit ?,?";
		params.add((pd-1)*ps);
		params.add(ps);
		List<Record> beanList = qr.query(sql, new BeanListHandler<Record>(Record.class),params.toArray());
		
		PageBean<Record> pb = new PageBean<Record>();
		pb.setBeanList(beanList);
		pb.setPs(ps);
		pb.setTr(tr);
		pb.setPd(pd);
		return pb;
	}
	
	//�Խ�ѧ�����ɾ�Ĳ�
		//����
		public void add(Record stu) throws SQLException{
			String sql = "insert into t_record values(null,?,?,?,?)";
			Object[] param = {stu.getName(),stu.getTname(),stu.getFiler(),stu.getPubtime()};
			qr.update(sql, param);
		}
		//ɾ��
		public void del(String ids) throws SQLException{
			String sql = "delete from t_record where id in(?)";
			qr.update(sql,ids);
		}

		/**
		 * @param uid
		 * @throws SQLException 
		 */
		public Record findRecord(String uid) throws SQLException {
			String sql = "select * from t_record where name=?";
			return qr.query(sql, new BeanHandler<Record>(Record.class),uid);
		}
	
}
