package com.qq986945193.javaweb.knowledge;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化的简单介绍 
 * 我们现在写两个配置文件，一个文件中存放中文信息，另一个存放英文信息
 * 我们使用一个类，来通过语言环境，最终识别加载哪一个文件的信息：ResourceBundle 
 * 什么语言环境：
 * Locale > 
 * zh_CN > 
 * en_US
 * new Locale("zh", "CN"); 
 * Locale.getDefault(); 
 * Locale.US
 * 资源文件名称的格式：基本名称+Locale部份+.properties
 * 例如：res_zh_CN.properties，其中基本名称为res，
 * 而zh_CN是Locale部份
 * 必须所有的资源文件基石名称要相同！不同之处就是Locale部件
 */
public class InternetIntroduce {
	public static void main(String[] args) {
		//得到locale
		Locale locale = Locale.US;
//		Locale locale = Locale.CHINA;
		//得到ResourceBundle
		//第一个参数为基本名称，第二个参数为Locale对象
		ResourceBundle resourceBundle = ResourceBundle.getBundle("res",locale);
		//使用resourceBundle对象获取文件资源信息
		System.out.println(resourceBundle.getString("username"));
		System.out.println(resourceBundle.getString("password"));
		System.out.println(resourceBundle.getString("login"));
	}
}
