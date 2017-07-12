package com.qq986945193.javaweb.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 根据省份获取到市的列表
 */
public class AjaxCityServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");
		/**
		 * 获取省份的名称，加载该省份对应的<province>元素
		 * 把元素转换成字符串发送给客户端
		 */
		/**
		 * 1,获取省份的名称
		 * 2，使用省份名称查找到对应的<province>元素
		 * 3，把<province>元素转换成字符串，发送
		 */
		try {
			/**
			 * 得到document
			 */
			SAXReader saxReader = new SAXReader();
			InputStream inputStream = this.getClass().getResourceAsStream("/china.xml");
			Document document = saxReader.read(inputStream);
			/**
			 * 获取参数
			 */
			String pname = request.getParameter("pname");//获取省份的名称
			System.out.println("name"+pname);
			Element proElement = (Element) document.selectSingleNode("//province[@name='" + pname + "']");
			String xmlString = proElement.asXML();//把元素转换成字符串
			response.getWriter().print(xmlString);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
