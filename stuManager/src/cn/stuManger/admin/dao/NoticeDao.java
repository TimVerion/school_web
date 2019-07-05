/**
 * 
 */
package cn.stuManger.admin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.stuManger.admin.domain.Notice;
import cn.stuManger.pager.Expression;
import cn.stuManger.pager.PageBean;
import cn.stuManger.pager.PageConstants;

/**
 * @date 2019年5月6日
 */
public class NoticeDao {
	QueryRunner qr = new TxQueryRunner();
	//通用查询
	//管理奖学金信息
			public PageBean<Notice> findAllNotice(List<Expression> exprList,int pd) throws SQLException{
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
				String sql = "select count(*) from t_notice"+whereSql;
				Number number = (Number)qr.query(sql,new ScalarHandler(),params.toArray());
				int tr = number.intValue();
				//得到beanList,及当前页记录
				sql = "select * from t_notice s"+whereSql+" limit ?,?";
				params.add((pd-1)*ps);
				params.add(ps);
				List<Notice> beanList = qr.query(sql, new BeanListHandler<Notice>(Notice.class),params.toArray());
				
				PageBean<Notice> pb = new PageBean<Notice>();
				pb.setBeanList(beanList);
				pb.setPs(ps);
				pb.setTr(tr);
				pb.setPd(pd);
				return pb;
			}
			
			public List<Notice> findAll() throws SQLException{
				String sql="select * from  t_notice";
				return qr.query(sql, new BeanListHandler<Notice>(Notice.class));
			
			}
			//增加
			public void add(Notice stu) throws SQLException{
				String sql = "insert into t_notice values(null,?,?,?)";
				Object[] param = {stu.getName(),stu.getGgpic(),stu.getNote()};
				qr.update(sql, param);
			}
			//删除
			public void del(String ids) throws SQLException{
				String sql = "delete from t_notice where ggid in(?)";
				qr.update(sql,ids);
			}
}
