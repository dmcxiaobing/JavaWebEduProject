package com.qq986945193.javaweb.knowledge;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.qq986945193.javaweb.domain.XomBean;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

/**
 * xom的使用简单介绍
 */
public class XomIntroduce {
	public static void main(String[] args) {
		List<XomBean> lists = new ArrayList<XomBean>();
		lists.add(new XomBean("zhangsan", "123"));
		lists.add(new XomBean("lisi","456"));
		//将列表中学生的数据--放入存放至根目录root下
		Element rooteElement = new Element("lists");
		for (XomBean bean : lists) {
			rooteElement.appendChild(bean.getXML());
		}
		//构造xml的Document对象
		Document document = new Document(rooteElement);
		//这里标签的名字都是可以根据我们所需要的更改。
		System.out.println(document.toXML());
//		<?xml version="1.0"?>
//		<lists><XomBean><first>zhangsan</first>123</XomBean><XomBean><first>lisi</first>456</XomBean></lists>
		/**
		 * 上面是直接toXML()打印的效果，下面我们给它进行一下格式化，更美观
		 */

		formatXml(document);
	}
	/**
	 *  将document进行xml的格式化
	 * @param document 需要格式化的Document对象
	 */
	private static void formatXml(Document document) {
		
		try {
			//这里我们只是打印输出的
			//Serializer serializer = new Serializer(System.out,"utf-8");
			//我们也可以直接将他保存为一个文件,这样就保存在了D盘目录下
			Serializer serializer = new Serializer(
					new BufferedOutputStream(new FileOutputStream("d:/XOM.xml")), "utf-8");
			//设置行缩进
			serializer.setIndent(4);
			//设置行最大长度
			serializer.setMaxLength(60);
			serializer.write(document);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
