package com.qq986945193.javaweb.servlet;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servelt的一些方法
 */
public class BrowserInfoServlet extends HttpServlet {
	/**
	 * post请求
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 关于设置编码 一定要在之前设置 默认是ISO-8859编码 获取到参数,post可以首先设置编码。
		 * 而get请求则需要修改tomcat中的/conf/server.xml文件,在修改端口的地方添加
		 * URIEncoding="UTF-8"即可。(不建议用) 可以用ISO-8859进行反编
		 */
		// 设置输入的文字编码为utf-8格式
		// response.setCharacterEncoding("utf-8");
		// 设置输入的文字编码并且告诉浏览器的文字编码是utf-8格式 第一种方法
		// response.setHeader("Content-Type", "text/html;charset=utf-8");
		// 设置输入的文字编码并且告诉浏览器的文字编码是utf-8格式 第二种方法
		response.setContentType("text/html;charset=utf-8");
		// 获取到请求方式 GET或者POST
		response.getWriter().print(request.getMethod());
		// 获取到ip
		response.getWriter().print(request.getRemoteAddr());
		// 获取到项目名 /Day10-2
		response.getWriter().print(request.getContextPath() + "<br/>");
		// 获取到来源地址 如从哪儿过来的 防盗链
		// response.getWriter().print(request.getHeader("Referer"));
		// 设置重定向 302 第二种方法
		// response.sendRedirect("http://www.baidu.com");
		response.getWriter().print("程序员小冰");
	}

	/**
	 * get请求
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
