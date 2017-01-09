package com.qq986945193.javaweb.servlet.day10.servlet01;
/**
 * 演示定时刷新  自动跳转
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
public class AutoTimeRefreshServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置输入的文字编码并且告诉浏览器的文字编码是utf-8格式 这样就不会出现乱码了
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("欢迎登陆,三秒钟自动跳转");
		/**
		 * 设置自动跳转，定时刷新  
		 * 名为Refresh的响应头
		 */
		response.setHeader("Refresh", "3;url=/JavaWebBase/RedirectBServlet");
		
	}

}
