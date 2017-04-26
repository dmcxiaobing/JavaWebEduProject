package com.qq986945193.javaweb.dao;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.qq986945193.javaweb.domain.UserBean;
import com.qq986945193.javaweb.servlet.day11.UserRegistServlet;

/**
 * dao持久层
 */
public class UserDao {
	

	/**
	 * 根据用户名进行查找
	 * 
	 * @param username
	 *            传来的用户名
	 */
	public UserBean findByUsername(String username) {
		/*
		 * 1、创建解析器、得到document
		 * 
		 * 2，利用xpath查询 3，检查查询结果是否为null,如果为null,则返回null 如果不为null，
		 * 则将element封装到user对象中
		 */

		// 得到document
		Document document;
		// 创建解析器
		SAXReader saxReader = new SAXReader();
		try {
			document = saxReader.read(UserRegistServlet.XML_PATH);
			Element element = (Element) document.selectSingleNode("//user[@username='" + username + "']");
			System.out.println("//user[@username='" + username + "']");
			// 若是为null则表示没有
			if (element == null) {
				return null;
			}

			// 将element的数据封装到user对象中
			UserBean userBean = new UserBean();
			String attributeUsername = element.attributeValue("username");// 获得用户名
			String attributePassword = element.attributeValue("password");// 获得密码
			userBean.setUsername(attributeUsername);
			userBean.setPassword(attributePassword);
			return userBean;
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 根据用户名添加进入数据库
	 */
	public void addByUserName(UserBean userBean) {
		/**
		 * 1,得到Document 通过document得到root根元素<users> 2,使用参数user，转发为element
		 * 。把element添加到root元素中 保存document
		 */
		// 得到document
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(UserRegistServlet.XML_PATH);
			// 得到根元素
			Element rootElement = document.getRootElement();
			// 通过根元素创建新元素
			Element userElement = rootElement.addElement("user");
			// 为user的element设置属性和值
			userElement.addAttribute("username", userBean.getUsername());
			userElement.addAttribute("password", userBean.getPassword());
			/**
			 * 保存文档
			 */
			// 创建输出格式化器 缩进使用\t 是否换行，这里选择是
			OutputFormat format = new OutputFormat("\t", true);
			format.setTrimText(true);// 清空原有的换行和缩进
			// 创建xmlWriter
			XMLWriter xmlWriter;
			xmlWriter = new XMLWriter(new OutputStreamWriter(new FileOutputStream(UserRegistServlet.XML_PATH), "utf-8"),format);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}

	}
}
