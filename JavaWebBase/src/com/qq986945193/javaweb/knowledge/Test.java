package com.qq986945193.javaweb.knowledge;


import com.qq986945193.javaweb.utils.GetUUIDRandomUtils;
import com.qq986945193.javaweb.utils.PathUtils;

/**
 * 一个用来测试的类
 */
public class Test {
	public static void main(String[] args) {
		System.out.println(PathUtils.getJarPath(UploadIntroduceServlet.class)+"\\files"+GetUUIDRandomUtils.getUUIDRandomNum()+"_");
		String xml = "<students>"
				+ "<student number = '01'>"
				+ "<name>zhangsan</name>"
				+ "<age>22</age>"
				+ "<sex>male</sex>"
				+ "</student></students>";
		 xml = "<students>" +
				"<student number='ITCAST_1001'>" +
				"<name>zhangSan</name>" +
				"<age>18</age>" + 
				"<sex>male</sex>" +
				"</student>" +
				"</students>";
		System.out.println(xml);
	}
}

