package com.qq986945193.javaweb.servlet.day10.servlet03;
/**
 * 测试post请求，获取参数
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

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
public class CheckParServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 获取客户端传来的参数
		 */
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String hobby[] = request.getParameterValues("hobby");
		System.out.println(username+","+password+","+Arrays.toString(hobby));
		/**
		 * 利用Enumeration获取所有参数的名称
		 */
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String nameValue = names.nextElement();
			System.out.print(nameValue+",");
		}
		System.out.println("--------------");
		/**
		 * 获取所有请求参数，封装到map中
		 */
		Map<String, String[]> map = request.getParameterMap();
		for (String name:map.keySet()) {
			String[] values = map.get(name);
			System.out.print(name +","+Arrays.toString(values)+"--");
		}
	}
}
