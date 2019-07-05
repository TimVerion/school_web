package cn.stuManger.stu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.servlet.BaseServlet;
import cn.stuManger.stu.domain.Student;
import cn.stuManger.stu.service.Service;

/**
 * Servlet implementation class StuServlet
 */
@WebServlet("/StuServlet")
public class StuServlet extends BaseServlet {
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
			return "f:/jsps/user/login.jsp";
		}
		
		boolean login = false;
		Student stu = null;
		try {
			stu = service.findStu(username);
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
		session.setAttribute("user",stu.getTname() );
		return "r:/jsps/main.jsp";
	}
	//个人信息查询
	public String findStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String uid = request.getParameter("uid");
		Student findStu = service.findStu(uid);
//		request.getSession().setAttribute("user", findStu.getTname());
		request.setAttribute("user", findStu);
		return "/jsps/stu/studesc.jsp";
	}
}
