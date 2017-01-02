package com.qq986945193.javaweb.utils;

import java.beans.Encoder;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.sound.sampled.AudioFormat.Encoding;

import org.junit.Test;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
/**
 * 关于编码的转换工具类
 */
public class CharsetUtils {
	/**
	 * 将iso-8859-1编码转换为utf-8编码
	 * 
	 * @param parameter
	 *            iso-8859-1的字符串
	 * @return
	 */
	public static String getGetMethodParameter(String parameter) {
		// 将字符串转为字节数组
		byte[] b = null;
		try {
			b = parameter.getBytes("iso-8859-1");
			return new String(b, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 将 中文字符串进行编码 URLEncoder
	 * 
	 * @param text
	 *            传入一个中文字符串 eg:程序员小冰
	 * @return 返回一个编码后的字符串 eg： %E4%B8%AD%E5%9B%BD
	 */
	@Test
	public String getURLEncoder(String text) {
		try {
			return URLEncoder.encode(text, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}

	/**
	 * 将 URLEncoder编码进行转换为中文字符串
	 * 
	 * @param text
	 *            传入URLEncoder字符串eg: %E4%B8%AD%E5%9B%BD
	 * 
	 * @return 返回一个中文字符串 eg:程序员小冰
	 */
	@Test
	public String getURLDecoder(String text) {
		try {
			return URLDecoder.decode(text, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}

}
