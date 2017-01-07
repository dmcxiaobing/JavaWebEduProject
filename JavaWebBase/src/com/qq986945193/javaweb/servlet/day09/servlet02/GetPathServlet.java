package com.qq986945193.javaweb.servlet.day09.servlet02;

/**
 * 使用ServletContext获取资源路径
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
public class GetPathServlet extends HttpServlet {

	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 得到它所有盘符的绝对路径
		 * D:\Users\apache-tomcat-8.5.8\webapps\JavaWebBase\index.jsp
		 */
		String path = this.getServletContext().getRealPath("/index.jsp");
		System.out.println(path);
		/**
		 * 获取资源的路径后，再创建输入流对象
		 */
		InputStream inputStream = this.getServletContext().getResourceAsStream(
				"/index.jsp");
		/**
		 * 获取此目录下的所有文件：[/WEB-INF/lib/, /WEB-INF/classes/, /WEB-INF/web.xml]
		 */
		Set<String> set = this.getServletContext().getResourcePaths("/WEB-INF");
		System.out.println(set);

	}

}
