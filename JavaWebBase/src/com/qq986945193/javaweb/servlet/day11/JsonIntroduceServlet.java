package com.qq986945193.javaweb.servlet.day11;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 只是一个向客户端发送json字符串的功能
 */
public class JsonIntroduceServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 向客户端发送json字符串
		 */
		String jsonString = "{\"name\":\"zhangSan\",\"age\":15,\"sex\":\"boy\"}";
		response.getWriter().write(jsonString);
		System.out.println(jsonString);
	}

}
