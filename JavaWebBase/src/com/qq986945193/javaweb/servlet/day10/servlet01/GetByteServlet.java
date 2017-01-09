package com.qq986945193.javaweb.servlet.day10.servlet01;

/**
 * 字节的一些使用
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
public class GetByteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String string = "hello world";
		byte[] byte1 = string.getBytes();
		// response.getWriter().print(byte1);
		/**
		 * 演示响应字节数据
		 */
		// 把一张图片读取到字节数组中
		ClassLoader classLoader = this.getClass().getClassLoader();
		// 相当于从classes
		InputStream fileInputStream = classLoader
				.getResourceAsStream("/../../imgs/android_.jpg");
		// String path = "D:/android_.jpg";
		// FileInputStream fileInputStream = new FileInputStream(path);
		byte[] byte2 = IOUtils.toByteArray(fileInputStream);
		response.getOutputStream().write(byte2);

		// IOUtils.write(byte2, response.getOutputStream());
	}

}
