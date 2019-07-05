package cn.stuManger.admin.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AServlet
 */
@SuppressWarnings("all")
@WebServlet("/AServlet")
public class AServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String filename = request.getParameter("filer");
		// 1. 获取真实路径
		String savepath = this.getServletContext().getRealPath("/record");
		/*
		 * 2. 创建目标文件
		 */
		File file = new File(savepath, filename);
		Reader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		StringBuffer sb = new StringBuffer();
		String str= null;
		try {
			while((str=br.readLine())!=null){
				sb.append(str+"\n");
				
			}
//			System.out.println(sb);
			response.getWriter().print(sb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
