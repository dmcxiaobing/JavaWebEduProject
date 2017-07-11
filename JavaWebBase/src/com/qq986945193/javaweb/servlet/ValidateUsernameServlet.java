package com.qq986945193.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 一个验证用户名是否存在的servlet
 */
public class ValidateUsernameServlet extends HttpServlet {
	/**
	 * 验证用户名是否存在
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		if (username.equals("david")) {
			//假如这里david表示已经注册
			response.getWriter().print("1");
		}else {
			response.getWriter().print("0");
		}
	}

}
