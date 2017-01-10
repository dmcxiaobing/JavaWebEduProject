package com.qq986945193.javaweb.servlet.day10.servlet02;

/**
 * 通过request获取url的一些方法
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
public class GetUrlInfoServlet extends HttpServlet {
	/**
	 * 通过request来获取url的相关方法
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 获取请求协议:http 获取服务器名称:127.0.0.1 获取服务器端口号:8080 获取项目名称:/JavaWebBase
		 * 获取项目路径:/GetUrlInfoServlet 获取参数部分:null
		 * 获取请求URI:/JavaWebBase/GetUrlInfoServlet
		 * 获取请求的url:http://127.0.0.1:8080/JavaWebBase/GetUrlInfoServlet
		 */
		// 设置输入的文字编码并且告诉浏览器的文字编码是utf-8格式
		response.setContentType("text/html;charset=utf-8");
		// 获取请求协议
		response.getWriter().println("获取请求协议:" + request.getScheme() + "<br/>");
		// 获取服务器名称
		response.getWriter().println(
				"获取服务器名称:" + request.getServerName() + "<br/>");
		// 获取服务器端口号
		response.getWriter().println(
				"获取服务器端口号:" + request.getServerPort() + "<br/>");
		// 获取项目名称
		response.getWriter().println(
				"获取项目名称:" + request.getContextPath() + "<br/>");
		// 获取项目路径
		response.getWriter().println(
				"获取项目路径:" + request.getServletPath() + "<br/>");
		// 获取参数部分
		response.getWriter().println(
				"获取参数部分:" + request.getQueryString() + "<br/>");
		// 获取请求URI
		response.getWriter().println(
				"获取请求URI:" + request.getRequestURI() + "<br/>");
		// 获取请求的url
		response.getWriter().println(
				"获取请求的url:" + request.getRequestURL() + "<br/>");

	}

}
