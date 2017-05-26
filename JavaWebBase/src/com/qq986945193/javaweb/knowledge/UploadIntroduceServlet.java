package com.qq986945193.javaweb.knowledge;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.qq986945193.javaweb.utils.CommonUtils;
import com.qq986945193.javaweb.utils.GetUUIDRandomUtils;
import com.qq986945193.javaweb.utils.PathUtils;

/**
 * 上传的功能简单详解
 */
public class UploadIntroduceServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 解决乱码的问题
		response.setContentType("text/html;charset=utf-8");
//		getFileInfo(request, response);
//		introduceUploadFile(request,response);
		uploadFile(request,response);

	}
	/**
	 * 上传文件 处理文件名是否带有绝对路径
	 * @param request
	 * @param response
	 */
	private void uploadFile(HttpServletRequest request, HttpServletResponse response) {
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		//设置 限制单个文件大小为100K
		//servletFileUpload.setFileSizeMax(100*1024);
		//限制整个表单大小为1M
		//servletFileUpload.setSizeMax(1024*1024);
		//解析 得到fileItem的集合
		try {
			List<FileItem> fileItems = servletFileUpload.parseRequest(request);
			//这里表单有两个，直接数据写出
			FileItem fileItem = fileItems.get(1);
			//得到文件保存的路径
			String rootPath = this.getServletContext().getRealPath("/WEB-INF/files");
			/**
			 * 生成二层目录
			 * 1，得到文件名称。根据hashCode值转成16进制，获取前两个字符用来生成目录
			 */
		
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
			//得到hashCode 并转换为19进制
			int hcode = fileName.hashCode();
			String hex = Integer.toHexString(hcode);
			//获取hex的钱两个字母与rootpath连接一起，生成一个完整的路径
			File dirFile = new File(rootPath,hex.charAt(0)+"/"+hex.charAt(1));
			//创建目录涟
			dirFile.mkdirs();
			//创建目录文件
			File saveFile = new File(dirFile,saveFileName);
			//保存
			fileItem.write(saveFile);
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			//这里可以做上传文件大小限制
			if (e instanceof FileUploadBase.FileSizeLimitExceededException) {
				System.out.println("您上传的文件超出了大小");
			}
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 演示上传文件，这里借助Commons的jar文件
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	private void introduceUploadFile(HttpServletRequest request, HttpServletResponse response) {
		/**
		 * 上传分为三步，1得到工厂，2通过工厂创建解析器，
		 * 3，解析request，得到FileItem集合，遍历FileItem，完成文件的保存
		 */
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		//得到FileItem集合
		try {
			List<FileItem> fileItems = servletFileUpload.parseRequest(request);
			//遍历文件，这里由于只有两个参数 username和file文件，所以，就直接写位置了
			FileItem fileItem1 = fileItems.get(0);
			FileItem fileItem2 = fileItems.get(1);
			
			String fileType = fileItem2.getContentType();
			System.out.println("普通表单演示："+fileItem1.getFieldName());
			System.out.println("size:"+fileItem2.getSize());
			System.out.println("文件类型："+fileType);
			System.out.println("文件名称："+fileItem2.getName());
			//保存文件到 我们的WEB-INF的files目录下
			//以防文件重复，这里用UUID进行拼接，
			File file = new File(PathUtils.getJarPath(UploadIntroduceServlet.class)+"\\files\\",GetUUIDRandomUtils.getUUIDRandomNum()+"_"+fileItem2.getName());
			fileItem2.write(file);
			response.getWriter().print("上传成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获得上传文件的信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void getFileInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletInputStream inputStream = request.getInputStream();
		String filename = IOUtils.toString(inputStream);
		System.out.println(filename);
		// 直接利用IoUtils操作
		IOUtils.copy(inputStream, response.getOutputStream());

	}

}
