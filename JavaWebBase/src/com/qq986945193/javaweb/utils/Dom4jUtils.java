package com.qq986945193.javaweb.utils;

/**
 * @Author ：程序员小冰
 * @GitHub: https://github.com/QQ986945193
 */
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

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
//			OutputFormat format = OutputFormat.createPrettyPrint();
			
			//缩进使用\t，是否换行，TRUE是
			OutputFormat format2 = new OutputFormat("\t",true);
			//清空原有的换行和 缩进
			format2.setTrimText(true);
			//写入以及设置编码
			XMLWriter xmlWriter = new XMLWriter(new OutputStreamWriter(new FileOutputStream(path),"utf-8"), format2);
//			XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path), format);
			//保存docment对象
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
