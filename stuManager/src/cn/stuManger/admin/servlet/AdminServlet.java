package cn.stuManger.admin.servlet;

import java.io.IOException;



import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import com.alibaba.fastjson.JSON;

import cn.itcast.servlet.BaseServlet;
import cn.stuManger.admin.domain.Admin;
import cn.stuManger.admin.service.Service;
import cn.stuManger.pager.PageBean;
import cn.stuManger.stu.domain.Student;
import cn.stuManger.teacher.domain.Teacher;

/**
 * Servlet implementation class StuServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private Service service = new Service();
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String img = request.getParameter("verifycode");
		String id = request.getParameter("id");
		//�ж���֤��
		String text = (String) request.getSession().getAttribute("session_vcode");
		System.out.println(text);
		if(!img.equalsIgnoreCase(text)){
			request.setAttribute("imgmsg","��֤�����" );
			return "f:jsps/user/login.jsp";
		}
		
		boolean login = false;
		try {
			login = service.login(username, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!login){
			request.setAttribute("msg", "�û������������");
			return "f:jsps/user/login.jsp";
		}
		//����session
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("id", id);
		return "r:/jsps/main.jsp";
	}
	//������Ϣ
	public String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		uid = new String(uid.getBytes("iso-8859-1"),"utf-8");
		try {
			Admin admin= service.find(uid);
			request.setAttribute("user", admin);
			return "f:jsps/admin/admin.jsp";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	//ѧ����Ϣ����
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//1.��õ�ǰҳ��
		int pd = getPd(request);
		//2.����PageBean
		PageBean<Student> pb = service.findAll(pd);
		//3.����pb��url
		String url = getUrl(request);
		pb.setUrl(url);
		request.setAttribute("pb", pb);
		return "/jsps/admin/stulist.jsp";
	}
	//
	public void findAlStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Student> list = service.findAlStu();
		Object json = JSON.toJSON(list);
		response.getWriter().print(json);
	}
	//���url
	private String getUrl(HttpServletRequest request) {
		String uri = request.getRequestURI();//��Դ·��
		String queryString = request.getQueryString();//����
		
		//��ȥҳ�룬��ҳ��������
		if(queryString.contains("&pd")){
		    int index = queryString.indexOf("&pd");
			queryString = queryString.substring(0,index);
		}
		//������������
		try {
			queryString = new String(queryString.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uri+"?"+queryString;
	}
	//��õ�ǰҳ��
	private int getPd(HttpServletRequest request) {
		String pd = request.getParameter("pd");
		if(pd==null || pd.trim().isEmpty()){
			return 1;
		}
		return Integer.valueOf(pd);
	}
	//��ѧ�����й���
	//ɾ��
	public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String ids = request.getParameter("ids");
		service.del(ids);
		response.getWriter().print(true);
	}
	//ģ����ѯ
	public String mohu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String tname = request.getParameter("tname");
		tname=new String(tname.getBytes("iso-8859-1"),"utf-8");
		//1.��õ�ǰҳ��
		int pd = getPd(request);
		//2.����PageBean
		PageBean<Student> pb = service.mohu(tname,pd);
		//3.����pb��url
		String url = getUrl(request);
		pb.setUrl(url);
		request.setAttribute("pb", pb);
	    return "/jsps/admin/stulist.jsp";
	}
	//�޸Ĳ�ѯ
	public String findStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		Student findStu = service.findStu(id);
		request.setAttribute("user", findStu);
		return "/jsps/admin/stuupdate.jsp";
	}
	//��ʦ��Ϣ����
		public String findAllTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			//1.��õ�ǰҳ��
			int pd = getPd(request);
			//2.����PageBean
			PageBean<Teacher> pb = service.findAllTeacher(pd);
		//	System.out.println(pb);
			//3.����pb��url
			String url = getUrl(request);
			pb.setUrl(url);
			request.setAttribute("pb", pb);
			return "/jsps/admin/tealist.jsp";
		}
		//
		public void findAlTea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			List<Teacher> list = service.findAlTea();
			Object json = JSON.toJSON(list);
			response.getWriter().print(json);
		}
		//����ʦ���й���
		//ɾ��
		public void delTea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			String ids = request.getParameter("ids");
			service.delTea(ids);
			response.getWriter().print(true);
		}
		//ģ����ѯ
		public String mohuTea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			String tname = request.getParameter("tname");
			tname=new String(tname.getBytes("iso-8859-1"),"utf-8");
			//1.��õ�ǰҳ��
			int pd = getPd(request);
			//2.����PageBean
			PageBean<Teacher> pb = service.mohuTea(tname,pd);
			//3.����pb��url
			String url = getUrl(request);
			pb.setUrl(url);
			request.setAttribute("pb", pb);
		    return "/jsps/admin/tealist.jsp";
		}
		//�޸Ĳ�ѯ
		public String findTea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			String id = request.getParameter("id");
			Teacher findStu = service.findTea(id);
			request.setAttribute("user", findStu);
			return "/jsps/admin/teaupdate.jsp";
		}
}
