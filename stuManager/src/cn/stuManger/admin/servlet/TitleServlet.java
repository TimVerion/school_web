package cn.stuManger.admin.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.stuManger.admin.domain.Title;
import cn.stuManger.admin.service.TitleService;
import cn.stuManger.pager.PageBean;

/**
 * Servlet implementation class TitleServlet
 */
@SuppressWarnings("all")
@WebServlet("/TitleServlet")
public class TitleServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	TitleService service =  new TitleService();
	//奖学金信息管理
		public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			//1.获得当前页码
			int pd = getPd(request);
			//2.创建PageBean
			PageBean<Title> pb = service.findAll(pd);
			//3.设置pb的url
			String url = getUrl(request);
			pb.setUrl(url);
			request.setAttribute("pb", pb);
			return "/jsps/admin/titlelist.jsp";
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
		//对奖学金进行管理
		//删除
		public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			String ids = request.getParameter("ids");
			service.del(ids);
			response.getWriter().print(true);
		}
		//查询
				public String findTitle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
					String uid = request.getParameter("uid");
					uid = new String(uid.getBytes("iso-8859-1"),"utf-8");
					Title findStu = service.findTitle(uid);
					request.setAttribute("title", findStu);
					return "/jsps/title/titledesc.jsp";
				}
}
