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
		//判断验证码
		String text = (String) request.getSession().getAttribute("session_vcode");
		System.out.println(text);
		if(!img.equalsIgnoreCase(text)){
			request.setAttribute("imgmsg","验证码错误" );
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
			request.setAttribute("msg", "用户名或密码错误");
			return "f:jsps/user/login.jsp";
		}
		//设置session
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("id", id);
		return "r:/jsps/main.jsp";
	}
	//个人信息
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
	//学生信息管理
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//1.获得当前页码
		int pd = getPd(request);
		//2.创建PageBean
		PageBean<Student> pb = service.findAll(pd);
		//3.设置pb的url
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
	//获得url
	private String getUrl(HttpServletRequest request) {
		String uri = request.getRequestURI();//资源路径
		String queryString = request.getQueryString();//参数
		
		//减去页码，有页面来决定
		if(queryString.contains("&pd")){
		    int index = queryString.indexOf("&pd");
			queryString = queryString.substring(0,index);
		}
		//处理中文乱码
		try {
			queryString = new String(queryString.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uri+"?"+queryString;
	}
	//获得当前页码
	private int getPd(HttpServletRequest request) {
		String pd = request.getParameter("pd");
		if(pd==null || pd.trim().isEmpty()){
			return 1;
		}
		return Integer.valueOf(pd);
	}
	//对学生进行管理
	//删除
	public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String ids = request.getParameter("ids");
		service.del(ids);
		response.getWriter().print(true);
	}
	//模糊查询
	public String mohu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String tname = request.getParameter("tname");
		tname=new String(tname.getBytes("iso-8859-1"),"utf-8");
		//1.获得当前页码
		int pd = getPd(request);
		//2.创建PageBean
		PageBean<Student> pb = service.mohu(tname,pd);
		//3.设置pb的url
		String url = getUrl(request);
		pb.setUrl(url);
		request.setAttribute("pb", pb);
	    return "/jsps/admin/stulist.jsp";
	}
	//修改查询
	public String findStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		Student findStu = service.findStu(id);
		request.setAttribute("user", findStu);
		return "/jsps/admin/stuupdate.jsp";
	}
	//老师信息管理
		public String findAllTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			//1.获得当前页码
			int pd = getPd(request);
			//2.创建PageBean
			PageBean<Teacher> pb = service.findAllTeacher(pd);
		//	System.out.println(pb);
			//3.设置pb的url
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
		//对老师进行管理
		//删除
		public void delTea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			String ids = request.getParameter("ids");
			service.delTea(ids);
			response.getWriter().print(true);
		}
		//模糊查询
		public String mohuTea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			String tname = request.getParameter("tname");
			tname=new String(tname.getBytes("iso-8859-1"),"utf-8");
			//1.获得当前页码
			int pd = getPd(request);
			//2.创建PageBean
			PageBean<Teacher> pb = service.mohuTea(tname,pd);
			//3.设置pb的url
			String url = getUrl(request);
			pb.setUrl(url);
			request.setAttribute("pb", pb);
		    return "/jsps/admin/tealist.jsp";
		}
		//修改查询
		public String findTea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			String id = request.getParameter("id");
			Teacher findStu = service.findTea(id);
			request.setAttribute("user", findStu);
			return "/jsps/admin/teaupdate.jsp";
		}
}
