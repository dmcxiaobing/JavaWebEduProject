package com.qq986945193.javaweb.servlet.day09.servlet04;

/**
 *获取类路径下的资源  重点ClassLoader;
 *Class类路径：
 *获取类路径资源，类路径对一个JavaWeb项目而言，就是/WEB-INF/classes和/WEB-INF/lib/每个jar包！
 *
 *ClassLoader：
 *这里要讲的是获取类路径下的资源，对于JavaWeb应用而言，就是获取classes目录下的资源。
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
public class GetClassLoaderServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 *获取类路径下的资源  重点ClassLoader;
		 *Class类路径：
		 *获取类路径资源，类路径对一个JavaWeb项目而言，就是/WEB-INF/classes和/WEB-INF/lib/每个jar包！
		 *
		 *ClassLoader：
		 *这里要讲的是获取类路径下的资源，对于JavaWeb应用而言，就是获取classes目录下的资源。
		 */
		/*
		 * 1. 得到ClassLoader > 先得到Class，再得到ClassLoader 2.
		 * 调用其getResourceAsStream()，得到一个InputStream
		 */
//		 ClassLoader cl = this.getClass().getClassLoader();
		// 相对/classes(这里要讲的是获取类路径下的资源，对于JavaWeb应用而言，就是获取classes目录下的资源。)  
//		 InputStream input = cl.getResourceAsStream("readme.txt");
		 //获取类路径资源，类路径对一个JavaWeb项目而言，就是/WEB-INF/classes和/WEB-INF/lib/每个jar包！
		Class c = this.getClass();
		// 相对当前.class文件所在目录！   即所在类生成的.class目录
//		 InputStream input = c.getResourceAsStream("../../../../../../readme.txt");
		// 相对classes下！即（D:\Users\apache-tomcat-8.5.8\webapps\JavaWebBase\WEB-INF\classes\readme.txt）
//		 InputStream input = c.getResourceAsStream("/readme.txt");
		//相当于从classes下找到readme.txt  即（D:\Users\apache-tomcat-8.5.8\webapps\JavaWebBase\readme.txt）
		InputStream input = c.getResourceAsStream("/../../readme.txt");
		String s = IOUtils.toString(input);// 读取输入流内容，转换成字符串返回
		System.out.println(s);
	}

}
