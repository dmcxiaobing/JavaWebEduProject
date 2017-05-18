package com.qq986945193.javaweb.servlet.day11;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193*/
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq986945193.javaweb.servlet.BaseServlet;

/**
 * 测试 访问BaseServlet 调用指定的方法
 */
public class TestBaseServlet extends BaseServlet {
	public void addServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("addServlet");
		resp.getWriter().write("addServlet");
	}

	public void deleteServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("deleteServlet");
		resp.getWriter().write("deleteServlet");
	}
	
	public String indexServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("IndexServlet");
		return "f:/index.jsp";
	}
	
	public String sendRedirectServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("IndexServlet");
		return "r:/login.html";
	}


}
