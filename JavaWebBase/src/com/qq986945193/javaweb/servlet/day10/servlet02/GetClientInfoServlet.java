package com.qq986945193.javaweb.servlet.day10.servlet02;
/**
 * 获取客户端的IP地址，网络请求方式，获取User-Agent,得到客户端的信息（操作系统 浏览器）
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
public class GetClientInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取客户端的IP地址
		String ipString = request.getRemoteAddr();
		System.out.println("客户端的IP地址是："+ipString);
		//获取客户端的请求方式
		System.out.println("请求方式是"+request.getMethod());
		//设置重定向 302
//		response.sendRedirect("http://weibo.com/mcxiaobing");
		//获取名为User-Agent的请求头
		String userAgent = request.getHeader("User-Agent");
		//简单判断得出用户使用的浏览器   toLowerCase()转换为小写
		if (userAgent.toLowerCase().contains("chrome")) {
			System.out.println("您好："+ipString+","+"您使用的是google内核浏览器");
		}else if (userAgent.toLowerCase().contains("firefox")) {
			System.out.println("您好："+ipString+","+"您使用的是Firefox内核浏览器");
		}else if (userAgent.toLowerCase().contains("msie")) {
			System.out.println("您好："+ipString+","+"您使用的是IE内核浏览器");
		}
	}

}
