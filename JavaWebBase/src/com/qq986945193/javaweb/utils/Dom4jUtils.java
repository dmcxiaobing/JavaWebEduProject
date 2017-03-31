package com.qq986945193.javaweb.utils;

/**
 * @Author ：程序员小冰
 * @GitHub: https://github.com/QQ986945193
 */
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * dom4j的简单封装
 */
public class Dom4jUtils {
	// 这里填写一个要读区的xml文件地址
	public static final String PATH = "src/person.xml";

	// 返回document
	public static Document getDocument(String path) {
		try {
			// 创建解析器
			SAXReader reader = new SAXReader();
			// 得到document
			Document document = reader.read(path);
			return document;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 回写xml的方法
	public static void xmlWriters(String path, Document document) {
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path), format);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
