package com.qq986945193.javaweb.servlet.day09.servlet04;
/**
 *获取类路径下的资源
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
		/*
		 * 1. 得到ClassLoader
		 *   > 先得到Class，再得到ClassLoader
		 * 2. 调用其getResourceAsStream()，得到一个InputStream
		 */
//		ClassLoader cl = this.getClass().getClassLoader();
		// 相对/classes
//		InputStream input = cl.getResourceAsStream("com/qq986945193/javaweb/servlet/day09/servlet04/readme.txt");
		
		Class c = this.getClass();
		// 相对当前.class文件所在目录！
//		InputStream input = c.getResourceAsStream("readme.txt");
		
		// 相对classes下！
//		InputStream input = c.getResourceAsStream("/readme.txt");
		
		InputStream input = c.getResourceAsStream("/../../index.jsp");
		
		String s = IOUtils.toString(input);//读取输入流内容，转换成字符串返回
		System.out.println(s);
	}

}
