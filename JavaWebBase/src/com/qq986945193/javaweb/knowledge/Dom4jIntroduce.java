package com.qq986945193.javaweb.knowledge;
/**
 * @Author ：程序员小冰
 * @GitHub: https://github.com/QQ986945193
 */

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.qq986945193.javaweb.utils.Dom4jUtils;

/**
 * 利用dom4j进行xml的增删改查
 *
 */
public class Dom4jIntroduce {
	public static void main(String[] args) throws Exception {
		// selectName();
		// selectSin();
		// selectSecond();
		// addSex();
		// addAgeBefore();
		// modifyAge();
		// delSch();
		// getValues();
		// test1XPATH();
		// test2XPATH();
		// saxReaderXml();
		byUsernameSelect();
	}

	/**
	 * 根据用户名查找value 利用xpath获取
	 */
	public static void byUsernameSelect() {
		/*
		 * 1、得到document 2、直接使用selectSingleNode方法实现 - xpath ：
		 * //user[@id1='aaaa']/name
		 */
		// 得到document
		Document document = Dom4jUtils.getDocument("src/user.xml");
		// String username = "lisi";
		// 直接使用selectSingleNode方法实现
		Element element = (Element) document.selectSingleNode("//user[@username='zhangsan']"); // username的元素
		// Element ele = (Element)document.selectSingleNode("//user[@username='"
		// + username + "']");
		// 得到name里面的值
		if (element == null) {
			System.out.println("为空");
		} else {
			System.out.println("不为空");
		}
		// 然后可以取出各个元素的值
		System.out.println(element.attributeValue("username"));
		System.out.println(element.attributeValue("password"));
	}

	// 获取第一个p1里面的属性id1的值
	public static void getValues() throws Exception {
		/*
		 * 1、得到document 2、得到根节点 3、得到第一个p1元素 4、得到p1里面的属性值
		 */
		// 得到document
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		// 得到根节点
		Element root = document.getRootElement();
		// 得到第一个p1元素
		Element p1 = root.element("p1");
		// 得到p1里面的属性值
		String value = p1.attributeValue("id1");
		System.out.println(value);
	}

	// 删除第一个p1下面的<school>ecit</school>元素
	public static void delSch() throws Exception {
		/*
		 * 1、得到document 2、得到根节点 3、得到第一个p1标签 4、得到第一个p1下面的school元素
		 * 5、删除（使用p1删除school）
		 * 
		 * 6、回写xml
		 */
		// 得到document ctrl shift o 快速导包
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		// 得到根节点
		Element root = document.getRootElement();
		// 得到第一个p1元素
		Element p1 = root.element("p1");
		// 得到p1下面的school标签
		Element sch = p1.element("school");
		// 删除school元素
		// 通过父节点删除
		// 获取父节点的方法
		// sch.getParent(); //获取到school的父节点p1
		p1.remove(sch);
		// 回写xml
		Dom4jUtils.xmlWriters(Dom4jUtils.PATH, document);
	}

	// 修改第一个p1下面的age元素的值 <age>30</age>
	public static void modifyAge() throws Exception {
		/*
		 * 1、得到document 2、得到根节点，然后再得到第一个p1元素 3、得到第一个p1下面的age 4、修改值是 30
		 * 
		 * 5、回写xml
		 * 
		 */
		// 得到document
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		// 得到第一个根节点
		Element root = document.getRootElement();
		// 得到第一个p1
		Element p1 = root.element("p1");
		// 得到p1下面的age
		Element age = p1.element("age");
		// 修改age的值
		age.setText("300");
		// 回写xml
		Dom4jUtils.xmlWriters(Dom4jUtils.PATH, document);
	}

	// 在第一个p1下面的age标签之前添加 <school>ecit.edu.cn</schlool>
	public static void addAgeBefore() throws Exception {
		/*
		 * 1、创建解析器 2、得到document 3、得到根节点 4、获取到第一个p1
		 * 
		 * 5、获取p1下面的所有的元素 ** elements()方法 返回 list集合 ** 使用list里面的方法，在特定位置添加元素 **
		 * 创建元素 在元素下面创建文本 *** add(int index, E element) - 第一个参数是 位置 下标，从0开始 -
		 * 第二个参数是 要添加的元素 6、回写xml
		 */
		// 创建解析器
		// SAXReader saxReader = new SAXReader();
		// 得到document
		// Document document = saxReader.read("src/p1.xml");

		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		// 得到根节点
		Element root = document.getRootElement();
		// 获取到第一个p1
		Element p1 = root.element("p1");
		// 获取p1下面的所有元素
		List<Element> list = p1.elements();
		// 创建元素 使用
		Element school = DocumentHelper.createElement("school");
		// 在school下面创建文本
		school.setText("ecit");
		// 在特定位置添加
		list.add(1, school);
		// 回写xml
		/*
		 * OutputFormat format = OutputFormat.createPrettyPrint(); XMLWriter
		 * xmlWriter = new XMLWriter(new FileOutputStream("src/p1.xml"),
		 * format); xmlWriter.write(document); xmlWriter.close();
		 */
		Dom4jUtils.xmlWriters(Dom4jUtils.PATH, document);
	}

	// 在第一个p1标签末尾添加一个元素 <sex>nv</sex>
	public static void addSex() throws Exception {
		/*
		 * 1、创建解析器 2、得到document 3、得到根节点
		 * 
		 * 4、获取到第一个p1 5、在p1下面添加元素 6、在添加完成之后的元素下面添加文本
		 * 
		 * 7、回写xml
		 */
		// 创建解析器
		// SAXReader reader = new SAXReader();
		// 得到document
		// Document document = reader.read("src/p1.xml");
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		// 得到根节点
		Element root = document.getRootElement();
		// 得到第一个p1元素
		Element p1 = root.element("p1");
		// 在p1下面直接添加元素
		Element sex1 = p1.addElement("sex");
		// 在sex下面添加文本
		sex1.setText("nv");

		// 回写xml
		// OutputFormat format = OutputFormat.createPrettyPrint(); //可以有缩进的效果
		//// OutputFormat format = OutputFormat.createCompactFormat();
		// XMLWriter xmlWriter = new XMLWriter(new
		// FileOutputStream("src/p1.xml"), format);
		// xmlWriter.write(document);
		// xmlWriter.close();
		Dom4jUtils.xmlWriters(Dom4jUtils.PATH, document);
	}

	// 获取第二个name元素里面的值
	public static void selectSecond() throws Exception {
		/*
		 * 1、创建解析器 2、得到document 3、得到根节点
		 * 
		 * 4、得到所有的p1 5、遍历得到第二个p1 6、得到第二个p1下面的name 7、得到name的值
		 */
		// 创建解析器
		SAXReader saxReader = new SAXReader();
		// 得到document
		Document document = saxReader.read("src/p1.xml");
		// 得到根节点
		Element root = document.getRootElement();
		// 得到所有的p1
		List<Element> list = root.elements("p1");
		// 得到第二个p1 list集合下标从0开始
		Element p2 = list.get(1);
		// 得到p1下面的name
		Element name2 = p2.element("name");
		// 得到name里面的值
		String s2 = name2.getText();
		System.out.println(s2);
	}

	// 获取到一个name元素里面的值
	public static void selectSin() throws Exception {
		/*
		 * 1、创建解析器 2、得到document 3、得到根节点
		 * 
		 * 4、得到第一个p1元素 5、得到p1下面的name元素 6、得到name元素里面的值
		 */
		// 创建解析器
		SAXReader saxReader = new SAXReader();
		// 得到document
		Document document = saxReader.read("src/p1.xml");
		// 得到根节点
		Element root = document.getRootElement();
		// 得到第一个p1
		Element p1 = root.element("p1");
		// 得到p1下面的name元素
		Element name1 = p1.element("name");
		// 得到name的值
		String s1 = name1.getText();
		System.out.println(s1);
	}

	// 查询xml中所有name元素的值
	public static void selectName() throws Exception {
		/*
		 * 1、创建解析器 2、得到document 3、得到根节点
		 * 
		 * 4、得到p1 5、得到p1下面的name 6、得到name里面的值
		 */
		// 创建解析器
		SAXReader saxReader = new SAXReader();
		// 得到document
		Document document = saxReader.read("src/p1.xml");
		// 得到根节点
		Element root = document.getRootElement();

		// 得到p1
		List<Element> list = root.elements("p1");
		// 遍历list
		for (Element element : list) {
			// element是每一个p1元素
			// 得到p1下面的name元素
			Element name1 = element.element("name");
			// 得到name里面的值
			String s = name1.getText();
			System.out.println(s);
		}
	}

	/**
	 * sax读取xml
	 */
	public static void saxReaderXml() {
		/*
		 * 1、创建解析器 2、得到document 3、得到根节点
		 * 
		 * 4、得到p1 5、得到p1下面的name 6、得到name里面的值
		 */
		// 创建解析器
		SAXReader saxReader = new SAXReader();
		// 得到document
		Document document;
		try {
			document = saxReader.read("src/p1.xml");
			// 得到根节点
			Element root = document.getRootElement();
			List<Element> list = root.elements("user");
			// 遍历list
			for (Element element : list) {
				// element是每一个p1元素
				// 得到p1下面的name元素
				Element name1 = element.element("username");
				// 得到name里面的值
				String s = name1.getText();
				System.out.println(s);
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 使用xpath实现：获取第一个p1下面的name的值
	public static void test1XPATH() throws Exception {
		/*
		 * 1、得到document 2、直接使用selectSingleNode方法实现 - xpath ：
		 * //p1[@id1='aaaa']/name
		 */
		// 得到document
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		// 直接使用selectSingleNode方法实现
		Node name1 = document.selectSingleNode("//p1[@id1='aaaa']/name"); // name的元素
		// 得到name里面的值
		String s1 = name1.getText();
		System.out.println(s1);
	}

	// 查询xml中所有name元素的值
	public static void test2XPATH() throws Exception {
		/*
		 * 1、得到document 2、直接使用selectNodes("//name")方法得到所有的name元素
		 * 
		 */
		// 得到document
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		// 使用selectNodes("//name")方法得到所有的name元素
		List<Node> list = document.selectNodes("//name");
		// 遍历list集合
		for (Node node : list) {
			// node是每一个name元素
			// 得到name元素里面的值
			String s = node.getText();
			System.out.println(s);
		}
	}
}
