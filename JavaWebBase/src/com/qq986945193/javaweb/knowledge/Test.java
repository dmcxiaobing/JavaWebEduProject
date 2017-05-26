package com.qq986945193.javaweb.knowledge;

import com.qq986945193.javaweb.utils.GetUUIDRandomUtils;
import com.qq986945193.javaweb.utils.PathUtils;

/**
 * 一个用来测试的类
 */
public class Test {
	public static void main(String[] args) {
		System.out.println(PathUtils.getJarPath(UploadIntroduceServlet.class)+"\\files"+GetUUIDRandomUtils.getUUIDRandomNum()+"_");
	}
}
