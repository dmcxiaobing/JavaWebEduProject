package com.qq986945193.javaweb.servlet.day09.servlet02;

import java.io.FileInputStream;
/**
 * 使用ServletContext获取资源路径
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getPath();
		loadFile();
	}

	private void getPath() {
		/**
		 * 得到它所有盘符的绝对路径
		 * D:\Users\apache-tomcat-8.5.8\webapps\JavaWebBase\index.jsp
		 */
		String path = this.getServletContext().getRealPath("/index.jsp");
		System.out.println(path);
		/**
		 * 获取资源的路径后，再创建输入流对象
		 */
		InputStream inputStream = this.getServletContext().getResourceAsStream("/index.jsp");
		/**
		 * 获取此目录下的所有文件：[/WEB-INF/lib/, /WEB-INF/classes/, /WEB-INF/web.xml]
		 */
		Set<String> set = this.getServletContext().getResourcePaths("/WEB-INF");
		System.out.println(set);
	}

	/**
	 * 读取文件内容
	 * 
	 * @throws IOException
	 */
	public void loadFile() throws IOException {
		/**
		 * 利用Properties读取配置文件 1，加载文件，得到IO流。然后利用properties对象加载IO流，然后根据属性获取值
		 */
		Properties props = new Properties();
//		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/dbconfig.properties");
//		props.load(in);
//		System.out.println(props.getProperty("url"));

		// in2的相对路径是tomcat的bin目录，所以这种方法要在该目录下建立文件夹classes，并把文件放在这里
		//得到绝对路径D:\KaiFaGongJu\apache-tomcat-8.5.12\webapps\javaweb\WEB-INF\classes\dbconfig.properties
		String path=this.getServletContext().getRealPath("/WEB-INF/classes/dbconfig.properties");
		//文件名\dbconfig.properties
		String filename=path.substring(path.lastIndexOf("\\"));
		System.out.println(path+"=="+filename);
		FileInputStream in2 = new FileInputStream(path);
		props.load(in2);
		System.out.println(props.getProperty("url"));
	}

}
