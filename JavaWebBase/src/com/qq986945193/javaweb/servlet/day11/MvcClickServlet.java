package com.qq986945193.javaweb.servlet.day11;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq986945193.javaweb.domain.User;
import com.qq986945193.javaweb.service.MvcClickService;
/**
 * 一个mvc的简单示例 
 */
public class MvcClickServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1,用户请求servlet，servlet依靠service业务层 ，业务层进行操作数据
		 */
		
		MvcClickService userService = new MvcClickService();
		User user = userService.findUser();
		request.setAttribute("user",user);
		request.getRequestDispatcher("/jsps/mvcsuccess.jsp").forward(request, response);
		
	}

}
