package cn.stuManger.admin.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.stuManger.admin.domain.Record;
import cn.stuManger.admin.service.RecordService;
import cn.stuManger.pager.PageBean;

/**
 * Servlet implementation class RecordServlet
 */
@SuppressWarnings("all")
@WebServlet("/RecordServlet")
public class RecordServlet extends BaseServlet {
	RecordService service = new RecordService();
	//��ѧ����Ϣ����
			public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
				//1.��õ�ǰҳ��
				int pd = getPd(request);
				//2.����PageBean
				PageBean<Record> pb = service.findAllRecord (pd);
				//3.����pb��url
				String url = getUrl(request);
				pb.setUrl(url);
				request.setAttribute("pb", pb);
				return "/jsps/admin/recordlist.jsp";
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
			//��ѯ
			public String findRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
				String uid = request.getParameter("uid");
				uid = new String(uid.getBytes("iso-8859-1"),"utf-8");
//				System.out.println(uid);
				Record findStu = service.findRecord(uid);
//				System.out.println(findStu);
				request.setAttribute("record", findStu);
				return "/jsps/record/recorddesc.jsp";
			}
}