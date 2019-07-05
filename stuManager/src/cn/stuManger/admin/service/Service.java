/**
 * 
 */
package cn.stuManger.admin.service;

import java.sql.SQLException;


import java.util.List;

import cn.stuManger.admin.dao.Dao;
import cn.stuManger.admin.domain.Admin;
import cn.stuManger.pager.PageBean;
import cn.stuManger.stu.domain.Student;
import cn.stuManger.teacher.domain.Teacher;

/**
 * @date 2019年5月2日
 */
public class Service {
	Dao dao = new Dao();
	public boolean login(String username,String pwd) throws SQLException{
		return dao.login(username, pwd);
	}
	/**
	 * @param username
	 * @param pwd
	 * @throws SQLException 
	 */
	//个人信息
	public Admin find(String uid) throws SQLException{
		return dao.find(uid);
	}
	//修改人人信息
	public void updateAdmin(Admin stu) throws SQLException {
		dao.updateAdmin(stu);
		
	}
	//管理学生信息
	public PageBean<Student> findAll(int pd) throws SQLException{
		return dao.findAllStudent(null,pd);
	}
	//对学生的增删该查
	//模糊查询
			public PageBean<Student> mohu(String name,int pd) throws SQLException{
				return dao.mohu(name, pd);
				
			}
			//增加
			public void add(Student stu) throws SQLException{
				dao.add(stu);
			}
			//删除
			public void del(String ids) throws SQLException{
				dao.del(ids);
			}
			//修改
			public void update(Student stu) throws SQLException{
				dao.update(stu);
			}
			//个人信息
			public Student findStu(String id) throws SQLException{
				return dao.findStu(id);
			}
			//
			public List<Student> findAlStu() throws SQLException {
				// TODO Auto-generated method stub
				return dao.findAlStu();
			}
	//管理老师信息
	public PageBean<Teacher> findAllTeacher(int pd) throws SQLException{
		return dao.findAllTeacher(null, pd);
	}
			//对老师表的管理
			//模糊查询
			public PageBean<Teacher> mohuTea(String name,int pd) throws SQLException{
				return dao.mohuTea(name, pd);
						
			}
			//增加
			public void addTea(Teacher stu) throws SQLException{
				dao.addTea(stu);
			}
			//删除
			public void delTea(String ids) throws SQLException{
				dao.delTea(ids);
			}
			//修改
			public void updateTea(Teacher stu) throws SQLException{
				dao.updateTea(stu);
		    }//个人信息
			public Teacher findTea(String id) throws SQLException {
				// TODO Auto-generated method stub
				return dao.findTea(id);
			}
			public List<Teacher> findAlTea() throws SQLException {
				return dao.findAlTea();
			}
				
}
