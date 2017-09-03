package com.qq986945193.javaweb.knowledge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * properties的功能简单介绍使用
 * 
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class PropertiesIntroduce {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("title", "the title");
		prop.put("name", "the name");

		try {
			// 保存
			FileOutputStream out = new FileOutputStream("DavidZheng.properties");
			// 为properties添加注释
			prop.store(out, "the properties's comment");
			out.close();

			// 读取
			FileInputStream in = new FileInputStream("program.properties");
			prop.load(in);
			System.out.println(prop.getProperty("title"));
			System.out.println(prop.getProperty("name"));
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
