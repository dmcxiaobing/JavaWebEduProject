package com.qq986945193.javaweb.servlet.day10.servlet04;

/**
 *关于编码的问题 
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
public class EncodingFormServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 这样我们直接得出的结果是乱码的。所以，我们需要进行转码
		// System.out.println(request.getParameter("username"));
		/*
		 * 1. 在获取参数之前，需要先调用request.setCharacterEncoding("utf-8"); 2.
		 * 使用getParameter()来获取参数
		 */
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("username");
		System.out.println(userName);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * 1,先获取到使用iso-8859-1提交来的字符串 2,拿到之后转换为字节数组，然后重新进行编码
		 */
		String usernameString = request.getParameter("username");
		byte[] bytes = usernameString.getBytes("iso-8859-1");
		usernameString = new String(bytes, "utf-8");
		System.out.println(usernameString);
		

	}

}
