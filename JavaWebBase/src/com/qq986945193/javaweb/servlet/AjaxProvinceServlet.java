package com.qq986945193.javaweb.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * ajax获取省份列表的servlet
 */
public class AjaxProvinceServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		try {
			/**
			 * 响应所有省份名称，使用逗号分隔!
			 */
			/**
			 * 1,Document对象。创建解析器对象。调用解析器的读方法，传递一个流对象。得到document
			 */
			SAXReader saxReader = new SAXReader();
			InputStream inputStream = this.getClass().getResourceAsStream("/china.xml");

			Document document = saxReader.read(inputStream);
			/**
			 * 查询所有province的name属性，得到一堆的属性对象
			 */
			List<Attribute> attributes = document.selectNodes("//province/@name");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < attributes.size(); i++) {
				sb.append(attributes.get(i).getValue());//把每一个属性的值放到sb中
				//中间以逗号分隔开
				if (i<attributes.size()-1) {
					sb.append(",");
				}
				
			}
			response.getWriter().print(sb);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
