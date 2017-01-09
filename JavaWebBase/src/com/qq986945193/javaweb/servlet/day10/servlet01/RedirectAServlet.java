package com.qq986945193.javaweb.servlet.day10.servlet01;
/**
 * 演示重定向302代码
 */
import java.io.IOException;
import java.io.PrintWriter;

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
public class RedirectAServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RedirectAServlet");
		/**
		 * 重定向：
		 * 1.设置location 重定向的地址
		 * 2.发送302状态码
		 */
//		response.setHeader("location", "/JavaWebBase/RedirectBServlet");
//		response.setStatus(302);
		/**
		 * 第二种 快捷方法
		 */
		response.sendRedirect("/JavaWebBase/RedirectBServlet");
		
	}

}
