package com.qq986945193.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示request获取请求参数
 */
public class LoginServlet extends HttpServlet {

	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * The doPost method of the servlet. <br>
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取所有请求的参数 保存到map中
		Map<String, String[]> maps = request.getParameterMap();
		for (String name : maps.keySet()) {
			// name则是请求参数的名称，valuse则是值
			String[] values = maps.get(name);

		}
	}

}
