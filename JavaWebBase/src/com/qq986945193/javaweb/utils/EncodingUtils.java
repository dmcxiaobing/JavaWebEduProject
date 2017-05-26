package com.qq986945193.javaweb.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import sun.misc.BASE64Encoder;

/**
 * 处理编码的一个工具类
 */
public class EncodingUtils {
	/**
	 * 用来对下载的文件名称进行编码
	 * @throws UnsupportedEncodingException 
	 */
	public static String filenameEncoding(String filename, HttpServletRequest request) throws UnsupportedEncodingException {
		String agent = request.getHeader("User-Agent"); // 获取浏览器
		if (agent.contains("Firefox")) {
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
		} else if (agent.contains("MSIE")) {
			filename = URLEncoder.encode(filename, "utf-8");
		} else {
			filename = URLEncoder.encode(filename, "utf-8");
		}
		return filename;
	}
}
