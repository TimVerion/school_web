package cn.stuManger.admin.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.stuManger.admin.domain.Award;
import cn.stuManger.admin.service.AwardService;

/**
 * Servlet implementation class AwardServlet
 */
@SuppressWarnings("all")
@WebServlet("/AwardServlet")
public class AwardServlet extends BaseServlet {
	AwardService service = new AwardService();
	
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Award> list = service.findAll();
		Object json = JSON.toJSON(list);
		response.getWriter().print(json);
	}
	
	//
	public String findAlAward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Award> list = service.findAll();
		request.setAttribute("list", list);
		return "f:/jsps/admin/awardlist.jsp";
	}
	//�Խ�ѧ����й���
	//ɾ��
	public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String ids = request.getParameter("ids");
		service.del(ids);
		response.getWriter().print(true);
	}
	//�޸Ĳ�ѯ
	public String findAward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		Award findStu = service.findById(id);
		request.setAttribute("user", findStu);
		return "/jsps/admin/awardupdate.jsp";
	}//�޸�
	public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Award award = CommonUtils.toBean(request.getParameterMap(), Award.class);
		service.update(award);
		request.setAttribute("msg", "�޸Ľ�����Ϣ�ɹ�");
		return "f:/jsps/hello.jsp";
	}//���
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		request.setCharacterEncoding("utf-8");
		Award award = CommonUtils.toBean(request.getParameterMap(), Award.class);
		service.add(award);
		request.setAttribute("msg", "��ӽ�����Ϣ�ɹ�");
		return "f:/jsps/hello.jsp";
	}
}
