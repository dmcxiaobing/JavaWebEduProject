package com.qq986945193.javaweb.servlet.day11;
/**
 * http://weibo.com/mcxiaobing
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 演示不乱码的请求处理 这里依赖EncodingFilter过滤器
 */
public class EncodingServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println("doget");
		response.getWriter().write(username);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		String username = request.getParameter("username");
		response.getWriter().write(username);
	}

}
