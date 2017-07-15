package com.qq986945193.javaweb.servlet;
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
/**
 * 这是一个返回xml的servlet，供ajax来解析使用的。
 */
public class AjaxXmlServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xml = "<students>"
				+ "<student number='01'>"
				+ "<name>zhangsan</name>"
				+ "<age>22</age>"
				+ "<sex>male</sex>"
				+ "</student>"
				+ "</students>";
		System.out.println(xml);
//		String xml = "<students>" +
//				"<student number='01'>" +
//				"<name>zhangSan</name>" +
//				"<age>18</age>" + 
//				"<sex>male</sex>" +
//				"</student>" +
//				"</students>";
		System.out.println(xml);
		//这个地方为text/xml
		response.setContentType("text/xml;charset=utf-8");
		response.getWriter().print(xml);
	}
	
}
