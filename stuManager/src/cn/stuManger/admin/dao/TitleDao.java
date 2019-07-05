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
import cn.stuManger.admin.domain.Title;
import cn.stuManger.pager.Expression;
import cn.stuManger.pager.PageBean;
import cn.stuManger.pager.PageConstants;

/**
 * @date 2019年5月6日
 */
public class TitleDao {
	QueryRunner qr = new TxQueryRunner();
	public PageBean<Title> findAllTitle(List<Expression> exprList,int pd) throws SQLException{
		//得到ps
		int ps = PageConstants.BOOK_PAGE_SIZE;//每页记录数
		//通过exprList来生成where子句
		StringBuilder whereSql = new StringBuilder(" where 1=1");
		List<Object> params = new ArrayList<Object>();
		if(exprList!=null){
			for(Expression expr:exprList){
				/*
				 * 1.以and开头
				 * 2.条件的名称
				 * 3.条件的运算符
				 * 4.如果条件不是isnull，再追加？，向params中添加对应的值
				 */
				whereSql.append(" and ").append(expr.getName()).append(" ")
				.append(expr.getOperator()).append(" ");
				if(!expr.getOperator().equals("is null")){
					whereSql.append("?");
					params.add(expr.getValue());
				}
			}
			
		}
		//总记录数
		String sql = "select count(*) from t_Title"+whereSql;
		Number number = (Number)qr.query(sql,new ScalarHandler(),params.toArray());
		int tr = number.intValue();
		//得到beanList,及当前页记录
		sql = "select * from t_title s"+whereSql+" limit ?,?";
		params.add((pd-1)*ps);
		params.add(ps);
		List<Title> beanList = qr.query(sql, new BeanListHandler<Title>(Title.class),params.toArray());
		
		PageBean<Title> pb = new PageBean<Title>();
		pb.setBeanList(beanList);
		pb.setPs(ps);
		pb.setTr(tr);
		pb.setPd(pd);
		return pb;
	}
		//删除
		public void del(String ids) throws SQLException{
			String sql = "delete from t_title where id in(?)";
			qr.update(sql,ids);
		}
		/**
		 * @param stu
		 * @throws SQLException 
		 */
		public void add(Title stu) throws SQLException {
				String sql = "insert into t_title values(null,?,?,?,?)";
				Object[] param = {stu.getTname(),stu.getImg(),stu.getName(),stu.getPubtime()};
				qr.update(sql, param);
			
		}
		/**
		 * @param uid
		 * @return
		 * @throws SQLException 
		 */
		public Title findTitle(String uid) throws SQLException {
			String sql = "select * from t_title where tname=?";
			return qr.query(sql, new BeanHandler<Title>(Title.class),uid);
		}
}
