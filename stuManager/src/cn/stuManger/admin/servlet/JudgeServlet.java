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
	//��ѧ����Ϣ����
		public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			//1.��õ�ǰҳ��
			int pd = getPd(request);
			//2.����PageBean
			PageBean<Judge> pb = service.findAllJudge(pd);
			//3.����pb��url
			String url = getUrl(request);
			pb.setUrl(url);
			request.setAttribute("pb", pb);
			return "/jsps/admin/judgelist.jsp";
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
		//�Խ�ѧ����й���
		//ɾ��
		public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			String ids = request.getParameter("ids");
			service.del(ids);
			response.getWriter().print(true);
		}
		//���
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
			request.setAttribute("msg", "��ӽ�ѧ����Ϣ�ɹ���");
			return "f:/jsps/hello.jsp";
		}
		//��ѯ
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
