package cn.stuManger.admin.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.itcast.servlet.BaseServlet;
import cn.stuManger.admin.domain.Award;
import cn.stuManger.admin.domain.Judge;
import cn.stuManger.admin.service.AwardService;
import cn.stuManger.admin.service.JudgeService;
import cn.stuManger.pager.PageBean;

/**
 * Servlet implementation class JudgeServlet
 */
@SuppressWarnings("all")
@WebServlet("/JudgeServlet")
public class JudgeServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JudgeService service =  new JudgeService();
	//奖学金信息管理
		public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			//1.获得当前页码
			int pd = getPd(request);
			//2.创建PageBean
			PageBean<Judge> pb = service.findAllJudge(pd);
			//3.设置pb的url
			String url = getUrl(request);
			pb.setUrl(url);
			request.setAttribute("pb", pb);
			return "/jsps/admin/judgelist.jsp";
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
		//添加
		public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			String tname = request.getParameter("tname");
			String name = request.getParameter("name");
			String pubtime = request.getParameter("pubtime");
//			System.out.println(tname+name+pubtime);
			Judge bean = new Judge();
			bean.setTname(tname);
			bean.setName(name);
			bean.setPubtime(pubtime);
		
			AwardService s = new AwardService();
			Award desc = s.desc(name);
//			System.out.println(desc);
			bean.setLevel(desc.getLevel());
			bean.setPrice(desc.getPrice());
			System.out.println(bean);
			
			service.add(bean);
			request.setAttribute("msg", "添加奖学金信息成功！");
			return "f:/jsps/hello.jsp";
		}
		//查询
		public String findJudge(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			String uid = request.getParameter("uid");
			uid = new String(uid.getBytes("iso-8859-1"),"utf-8");
//			System.out.println(uid);
			Judge findStu = service.findJudge(uid);
			AwardService s = new AwardService();
			Award award = s.desc(findStu.getName());
//			System.out.println(findStu);
			request.setAttribute("judge", findStu);
			request.setAttribute("award", award);
			return "/jsps/judge/judgedesc.jsp";
		}

}
