package com.qq986945193.javaweb.utils;

/**
 * @Author ：程序员小冰
 * @GitHub: https://github.com/QQ986945193
 */
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * cookie的一个工具类
 */
public class CookieUtils {
	/**
	 * 根据cookie的用户名 获取到cookie值
	 */
	public static String getCookValue(HttpServletRequest request, String name) {
		Cookie[] cs = request.getCookies();
		if (cs == null) {
			return null;
		}
		for (Cookie c : cs) {
			if (c.getName().equals(name)) {
				return c.getValue();
			}
		}
		return null;
	}
}
