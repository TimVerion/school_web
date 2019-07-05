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
import cn.stuManger.admin.domain.Admin;
import cn.stuManger.pager.Expression;
import cn.stuManger.pager.PageBean;
import cn.stuManger.pager.PageConstants;
import cn.stuManger.stu.domain.Student;
import cn.stuManger.teacher.domain.Teacher;
/**
 * @date 2019年5月2日
 */
public class Dao {
	private QueryRunner qr = new TxQueryRunner();
	//登陆
	public boolean login(String username,String pwd) throws SQLException{
		String sql = "select * from t_admin where uid=? and pwd=?";
		Object[] param = {username,pwd};
		Student query = qr.query(sql, new BeanHandler<Student>(Student.class),param);
		if(query != null){
			return true;
		}
		return false;
		
	}
	//管理员修改
	public void updateAdmin(Admin stu) throws SQLException {
		String sql = "update t_admin set pwd=?,img=?,tname=?,sex=?,tel=?,address=? where id=?";
		Object[] param = {stu.getPwd(),stu.getImg(),stu.getTname(),stu.getSex(),stu.getTel(),stu.getAddress(),stu.getId()};
		qr.update(sql,param);
		
	}
	//个人信息
	public Admin find(String uid) throws SQLException{
		String sql = "select * from t_admin where uid=?";
		return qr.query(sql, new BeanHandler<Admin>(Admin.class),uid);
		
	}
	//管理学生信息
	public PageBean<Student> findAllStudent(List<Expression> exprList,int pd) throws SQLException{
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
		String sql = "select count(*) from t_student"+whereSql;
		Number number = (Number)qr.query(sql,new ScalarHandler(),params.toArray());
		int tr = number.intValue();
		//得到beanList,及当前页记录
		sql = "select * from t_student s"+whereSql+" limit ?,?";
		params.add((pd-1)*ps);
		params.add(ps);
		List<Student> beanList = qr.query(sql, new BeanListHandler<Student>(Student.class),params.toArray());
		
		PageBean<Student> pb = new PageBean<Student>();
		pb.setBeanList(beanList);
		pb.setPs(ps);
		pb.setTr(tr);
		pb.setPd(pd);
		return pb;
	}
	
	//对学生的增删改查
	
	//模糊查询
		public PageBean<Student> mohu(String name,int pd) throws SQLException{
			List<Expression> exprList = new ArrayList<Expression>();
			exprList.add(new Expression("tname","like","%"+name+"%"));
			return findAllStudent(exprList, pd);
			
		}
		//增加
		public void add(Student stu) throws SQLException{
			String sql = "insert into t_student values(null,?,?,?,?,?,?,?,?)";
			Object[] param = {stu.getUid(),stu.getPwd(),stu.getImg(),stu.getTname(),stu.getSex(),stu.getTel(),stu.getClazz(),stu.getAddress()};
			qr.update(sql, param);
		}
		//删除
		public void del(String ids) throws SQLException{
			String sql = "delete from t_student where id in(?)";
			qr.update(sql,ids);
		}
		//修改
		public void update(Student stu) throws SQLException{
			String sql = "update t_student set uid=?,img=?,tname=?,sex=?,tel=?,clazz=?,address=? where id=?";
			Object[] param = {stu.getUid(),stu.getImg(),stu.getTname(),stu.getSex(),stu.getTel(),stu.getClazz(),stu.getAddress(),stu.getId()};
			qr.update(sql,param);
		}
		//个人信息
		public Student findStu(String id) throws SQLException{
			String sql = "select * from t_student where id=?";
			return qr.query(sql, new BeanHandler<Student>(Student.class),id);
			
		}
		//查询
		public List<Student> findAlStu() throws SQLException {
			String sql = "select tname from t_student";
			return qr.query(sql, new BeanListHandler<Student>(Student.class));
		}
	
	
	
	//管理老师信息
	public PageBean<Teacher> findAllTeacher(List<Expression> exprList,int pd) throws SQLException{
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
		String sql = "select count(*) from t_teacher"+whereSql;
		Number number = (Number)qr.query(sql,new ScalarHandler(),params.toArray());
		int tr = number.intValue();
		//得到beanList,及当前页记录
		sql = "select * from t_teacher s"+whereSql+" limit ?,?";
		params.add((pd-1)*ps);
		params.add(ps);
		List<Teacher> beanList = qr.query(sql, new BeanListHandler<Teacher>(Teacher.class),params.toArray());
		
		PageBean<Teacher> pb = new PageBean<Teacher>();
		pb.setBeanList(beanList);
		pb.setPs(ps);
		pb.setTr(tr);
		pb.setPd(pd);
		return pb;
	}
	//对老师表的管理
	//模糊查询
			public PageBean<Teacher> mohuTea(String name,int pd) throws SQLException{
				List<Expression> exprList = new ArrayList<Expression>();
				exprList.add(new Expression("tname","like","%"+name+"%"));
				return findAllTeacher(exprList, pd);
				
			}
			//增加
			public void addTea(Teacher stu) throws SQLException{
//				System.out.println(stu);
				String sql = "insert into t_teacher values(null,?,?,?,?,?,?,?,?)";
				Object[] param = {stu.getUid(),stu.getPwd(),stu.getImg(),stu.getTname(),stu.getSex(),stu.getTel(),stu.getAddress(),stu.getUtype()};
				qr.update(sql, param);
			}
			//删除
			public void delTea(String ids) throws SQLException{
				String sql = "delete from t_teacher where id in(?)";
				qr.update(sql,ids);
			}
			//修改
			public void updateTea(Teacher stu) throws SQLException{
				String sql = "update t_teacher set uid=?,img=?,tname=?,sex=?,tel=?,address=?,utype=? where id=?";
				Object[] param = {stu.getUid(),stu.getImg(),stu.getTname(),stu.getSex(),stu.getTel(),stu.getAddress(),stu.getUtype(),stu.getId()};
				qr.update(sql,param);
			}
			//个人信息
			public Teacher findTea(String id) throws SQLException {
				// TODO Auto-generated method stub
				String sql = "select * from t_teacher where id=?";
				return qr.query(sql, new BeanHandler<Teacher>(Teacher.class),id);
			}
			//查询
			public List<Teacher> findAlTea() throws SQLException {
				String sql = "select tname from t_teacher";
				return qr.query(sql, new BeanListHandler<Teacher>(Teacher.class));
			}
		
}
