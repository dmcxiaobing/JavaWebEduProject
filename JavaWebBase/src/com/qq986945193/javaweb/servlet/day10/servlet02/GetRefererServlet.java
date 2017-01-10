package com.qq986945193.javaweb.servlet.day10.servlet02;

/**
 * 使用Referer请求头，防止盗链
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
public class GetRefererServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 使用Referer请求头，来防止盗链
		 */
		String refererString = request.getHeader("Referer");
		System.out.println(refererString);
		if (refererString != null || refererString.contains("localhost")) {
			System.out.println("hello welcome");
		} else {
			response.sendRedirect("http://weibo.com/mcxiaobing");
		}
	}

}
