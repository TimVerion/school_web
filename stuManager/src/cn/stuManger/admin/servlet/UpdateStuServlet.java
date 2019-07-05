package cn.stuManger.admin.servlet;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.commons.CommonUtils;
import cn.stuManger.admin.service.Service;
import cn.stuManger.stu.domain.Student;

/**
 * Servlet implementation class UpdateStuServlet
 */
@SuppressWarnings("all")
@WebServlet("/UpdateStuServlet")
public class UpdateStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		/*
		 * 1. commons-fileupload���ϴ�����
		 */
		// ��������
		FileItemFactory factory = new DiskFileItemFactory();
		/*
		 * 2. ��������������
		 */
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setFileSizeMax(80 * 1024);//���õ����ϴ����ļ�����Ϊ80KB
		/*
		 * 3. ����request�õ�List<FileItem>
		 */
		List<FileItem> fileItemList = null;
		try {
			fileItemList = sfu.parseRequest(request);
		} catch (FileUploadException e) {
			// �����������첽��˵�������ļ�������80KB
			error("�ϴ����ļ�������80KB", request, response);
			return;
		}
		
		/*
		 * 4. ��List<FileItem>��װ��Book������
		 * 4.1 ���Ȱѡ���ͨ���ֶΡ��ŵ�һ��Map�У��ٰ�Mapת����Book��Category�����ٽ������ߵĹ�ϵ
		 */
		Map<String,Object> map = new HashMap<String,Object>();
		for(FileItem fileItem : fileItemList) {
			if(fileItem.isFormField()) {//�������ͨ���ֶ�
				map.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
			}
		}
		Student stu = CommonUtils.toBean(map, Student.class);//��Map�д󲿷����ݷ�װ��Book������
		
		/*
		 * 4.2 ���ϴ���ͼƬ��������
		 *   > ��ȡ�ļ�������ȡ֮
		 *   > ���ļ����ǰ׺��ʹ��uuidǰ׺��ΪҲ�����ļ�ͬ������
		 *   > У���ļ�����չ����ֻ����jpg
		 *   > У��ͼƬ�ĳߴ�
		 *   > ָ��ͼƬ�ı���·��������Ҫʹ��ServletContext#getRealPath()
		 *   > ����֮
		 *   > ��ͼƬ��·�����ø�Book����
		 */
		// ��ȡ�ļ���
		FileItem fileItem = fileItemList.get(2);//��ȡ��ͼ 
		System.out.println(fileItem);
		String filename = fileItem.getName();
		// ��ȡ�ļ�������Ϊ����������ϴ��ľ���·��
		int index = filename.lastIndexOf("\\");
		if(index != -1) {
			filename = filename.substring(index + 1);
		}
		// ���ļ������uuidǰ׺�������ļ�ͬ������
		filename = CommonUtils.uuid() + "_" + filename;
		// У���ļ����Ƶ���չ��
		if(!filename.toLowerCase().endsWith(".jpg")) {
			error("�ϴ���ͼƬ��չ��������JPG", request, response);
			return;
		}
		// У��ͼƬ�ĳߴ�
		// �����ϴ���ͼƬ����ͼƬnew��ͼƬ����Image��Icon��ImageIcon��BufferedImage��ImageIO
		/*
		 * ����ͼƬ��
		 * 1. ��ȡ��ʵ·��
		 */
		String savepath = this.getServletContext().getRealPath("/images/s_img");
		/*
		 * 2. ����Ŀ���ļ�
		 */
		File destFile = new File(savepath, filename);
	
		/*
		 * 3. �����ļ�
		 */
		try {
//			fileItem.write(destFile);//�������ʱ�ļ��ض���ָ����·������ɾ����ʱ�ļ�
			long size = fileItem.getSize();
			//�ϴ��ļ�����
			String contentType = fileItem.getContentType();
			//�����ļ���WEB-INFĿ¼��
			 InputStream in = fileItem.getInputStream();   //�õ��ϴ�����              
			 int len = 0;               
			 byte buffer[]= new byte[1024*36];                    
//			 String savepath = this.getServletContext().getRealPath("WEB-INF/upload");        
			 FileOutputStream out = new FileOutputStream(destFile);  //��uploadĿ¼��д���ļ�          
			 while((len=in.read(buffer))>0){                
				 out.write(buffer, 0, len);               
			 }               
			 in.close();          
			 out.close();  
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		// У��ߴ�
		// 1. ʹ���ļ�·������ImageIcon
		ImageIcon icon = new ImageIcon(destFile.getAbsolutePath());
		// 2. ͨ��ImageIcon�õ�Image����
		Image image = icon.getImage();
		// 3. ��ȡ���������У��
		if(image.getWidth(null) > 550 || image.getHeight(null) > 550) {
			error("���ϴ���ͼƬ�ߴ糬����500*500��", request, response);
			destFile.delete();//ɾ��ͼƬ
			return;
		}
		
		// ��ͼƬ��·�����ø�book����
		stu.setImg("images/s_img/" + filename);

		// ����service��ɱ���
		Service service = new Service();
		try {
			service.update(stu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ����ɹ���Ϣת����msg.jsp
		request.setAttribute("msg", "�޸�ѧ����Ϣ�ɹ���");
		request.getRequestDispatcher("/jsps/hello.jsp").forward(request, response);
	}
	
	/*
	 * ���������Ϣ��ת����add.jsp
	 */
	private void error(String msg, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/jsps/admin/stuupdate.jsp").
				forward(request, response);
	}
	}
