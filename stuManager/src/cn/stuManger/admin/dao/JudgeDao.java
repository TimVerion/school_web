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
import cn.stuManger.admin.domain.Judge;
import cn.stuManger.pager.Expression;
import cn.stuManger.pager.PageBean;
import cn.stuManger.pager.PageConstants;

/**
 * @date 2019年5月5日
 */
public class JudgeDao {
	private QueryRunner qr = new TxQueryRunner();
	//管理奖学金信息
		public PageBean<Judge> findAllJudge(List<Expression> exprList,int pd) throws SQLException{
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
			String sql = "select count(*) from t_judge"+whereSql;
			Number number = (Number)qr.query(sql,new ScalarHandler(),params.toArray());
			int tr = number.intValue();
			//得到beanList,及当前页记录
			sql = "select * from t_judge s"+whereSql+" limit ?,?";
			params.add((pd-1)*ps);
			params.add(ps);
			List<Judge> beanList = qr.query(sql, new BeanListHandler<Judge>(Judge.class),params.toArray());
			
			PageBean<Judge> pb = new PageBean<Judge>();
			pb.setBeanList(beanList);
			pb.setPs(ps);
			pb.setTr(tr);
			pb.setPd(pd);
			return pb;
		}
		
		//对奖学金的增删改查
			//增加
			public void add(Judge stu) throws SQLException{
				String sql = "insert into t_judge values(null,?,?,?,?,?,?)";
				Object[] param = {stu.getTname(),stu.getImg(),stu.getName(),stu.getLevel(),stu.getPrice(),stu.getPubtime()};
				qr.update(sql, param);
			}
			//删除
			public void del(String ids) throws SQLException{
				String sql = "delete from t_judge where id in(?)";
				qr.update(sql,ids);
			}

			/**
			 * @param uid
			 * @return
			 * @throws SQLException 
			 */
			public Judge findJudge(String uid) throws SQLException {
				String sql = "select * from t_judge where tname=?";
				return qr.query(sql, new BeanHandler<Judge>(Judge.class),uid);
			}
		
		
		
}
