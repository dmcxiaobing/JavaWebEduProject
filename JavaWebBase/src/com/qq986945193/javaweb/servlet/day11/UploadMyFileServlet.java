package com.qq986945193.javaweb.servlet.day11;
/**
 * @Author ：程序员小冰
 * @GitHub: https://github.com/QQ986945193
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.qq986945193.javaweb.servlet.BaseServlet;
import com.qq986945193.javaweb.utils.FileUtils;
import com.qq986945193.javaweb.utils.GetUUIDRandomUtils;

/**
 * 上传文件的servlet，网络硬盘的小功能
 */
public class UploadMyFileServlet extends HttpServlet {
	private List<File> listFiles = new ArrayList<File>();
	/**
	 * 上传文件
	 * 
	 * @param request
	 * @param response
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 解决乱码的问题
		response.setContentType("text/html;charset=utf-8");
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		List<FileItem> fileItems;
		try {
			fileItems = servletFileUpload.parseRequest(request);
			//这里表单有1个，直接数据写出
			FileItem fileItem = fileItems.get(0);
			//得到文件保存的路径
			String rootPath = this.getServletContext().getRealPath("/WEB-INF/files");
			//D:\KaiFaGongJu\apache-tomcat-8.5.12\webapps\javaweb\WEB-INF\files
			System.out.println(rootPath);
			String fileName = fileItem.getName();//获取上传的文件名称
			/**
			 * 处理文件名的绝对路径问题
			 */
			//返回最右边出现/的位置，若是不存在，则返回-1
			int index = fileName.lastIndexOf("\\");
			//如果包含则截取
			if (index!= -1) {
				fileName = fileName.substring(index+1);
			}
			String saveFileName = GetUUIDRandomUtils.getUUIDRandomNum()+"_"+fileName;
			//3FF12D362BD448BBA7B0B1AAABC0843A_db1
			System.out.println(saveFileName);
			File fie = new File(rootPath,saveFileName);
			fileItem.write(fie);
			response.getWriter().print("上传成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("上传失败");
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

}
