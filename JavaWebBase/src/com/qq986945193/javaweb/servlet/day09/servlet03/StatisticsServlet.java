package com.qq986945193.javaweb.servlet.day09.servlet03;

/**
 * 统计页面访问量的功能
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
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
public class StatisticsServlet extends HttpServlet {
	/**
	 * 通过Get请求进行统计网页访问量
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1. 获取ServletContext对象 2. 从ServletContext对象中获取名为count的属性.
		 * 3.如果存在：给访问量加1，然后再保存回去
		 * 4.如果不存在：说明是第一次访问，向Servletcontext中保存名为count的属性，值为1
		 */
		ServletContext mContext = this.getServletContext();
		Integer countInteger = (Integer) mContext.getAttribute("count");

		if (countInteger == null) {
			mContext.setAttribute("count", 1);
		} else {
			mContext.setAttribute("count", countInteger + 1);
		}
		// 向浏览器输出访问数量
		response.getWriter().print("<h1>" + mContext.getAttribute("count") + "</h1>");
	}

}
