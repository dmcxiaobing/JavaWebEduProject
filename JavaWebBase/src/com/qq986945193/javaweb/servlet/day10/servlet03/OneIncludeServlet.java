package com.qq986945193.javaweb.servlet.day10.servlet03;
/**
 * 演示请求包含
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
public class OneIncludeServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("OneIncludeServlet");
		response.getWriter().print("hello OneIncludeServlet");
		/**
		 * 请求包含
		 */
		request.getRequestDispatcher("/TwoIncludeServlet").include(request, response);
		
	}

}
