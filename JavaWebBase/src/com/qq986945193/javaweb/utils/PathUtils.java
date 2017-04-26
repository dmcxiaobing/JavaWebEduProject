package com.qq986945193.javaweb.utils;

import org.junit.Test;

/**
 * 获取项目发布后的文件路径。
 */
public class PathUtils {
	/**
	 * F:\MyEclipseSpace\GitHub\JavaWebEduProject\JavaWebBase\WebRoot\WEB-INF
	 * 
	 * @param clazz
	 *            类名:PathUtils.class
	 * @return 返回路径 即classes lib web.xml路径
	 */
	public static String getJarPath(Class clazz) {
		String path = clazz.getProtectionDomain().getCodeSource().getLocation().getFile();
		try {
			path = java.net.URLDecoder.decode(path, "UTF-8");
			java.io.File jarFile = new java.io.File(path);
			return java.net.URLDecoder.decode(jarFile.getParentFile().getAbsolutePath(), "UTF-8");
		} catch (java.io.UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * /F:/MyEclipseSpace/GitHub/JavaWebEduProject/JavaWebBase/WebRoot/WEB-INF/
	 * classes/
	 * 
	 * @param clazz
	 *            类名
	 * @return 即classes目录下
	 */
	public static String getClassesPath(Class clazz) {
		String path = clazz.getClassLoader().getResource("").getPath();
		try {
			return java.net.URLDecoder.decode(path, "UTF-8");
		} catch (java.io.UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Test
	public void test() {
		System.out.println(getJarPath(PathUtils.class));
		System.out.println(getClassesPath(PathUtils.class));
	}
}
