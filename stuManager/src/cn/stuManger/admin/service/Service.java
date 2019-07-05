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
 * @date 2019��5��2��
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
	//������Ϣ
	public Admin find(String uid) throws SQLException{
		return dao.find(uid);
	}
	//�޸�������Ϣ
	public void updateAdmin(Admin stu) throws SQLException {
		dao.updateAdmin(stu);
		
	}
	//����ѧ����Ϣ
	public PageBean<Student> findAll(int pd) throws SQLException{
		return dao.findAllStudent(null,pd);
	}
	//��ѧ������ɾ�ò�
	//ģ����ѯ
			public PageBean<Student> mohu(String name,int pd) throws SQLException{
				return dao.mohu(name, pd);
				
			}
			//����
			public void add(Student stu) throws SQLException{
				dao.add(stu);
			}
			//ɾ��
			public void del(String ids) throws SQLException{
				dao.del(ids);
			}
			//�޸�
			public void update(Student stu) throws SQLException{
				dao.update(stu);
			}
			//������Ϣ
			public Student findStu(String id) throws SQLException{
				return dao.findStu(id);
			}
			//
			public List<Student> findAlStu() throws SQLException {
				// TODO Auto-generated method stub
				return dao.findAlStu();
			}
	//������ʦ��Ϣ
	public PageBean<Teacher> findAllTeacher(int pd) throws SQLException{
		return dao.findAllTeacher(null, pd);
	}
			//����ʦ��Ĺ���
			//ģ����ѯ
			public PageBean<Teacher> mohuTea(String name,int pd) throws SQLException{
				return dao.mohuTea(name, pd);
						
			}
			//����
			public void addTea(Teacher stu) throws SQLException{
				dao.addTea(stu);
			}
			//ɾ��
			public void delTea(String ids) throws SQLException{
				dao.delTea(ids);
			}
			//�޸�
			public void updateTea(Teacher stu) throws SQLException{
				dao.updateTea(stu);
		    }//������Ϣ
			public Teacher findTea(String id) throws SQLException {
				// TODO Auto-generated method stub
				return dao.findTea(id);
			}
			public List<Teacher> findAlTea() throws SQLException {
				return dao.findAlTea();
			}
				
}
