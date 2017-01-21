package com.qq986945193.javaweb.utils;

import java.util.UUID;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */

/**
 * 生成32位的随机数 16位数字组成
 */
public class GetUUIDRandomUtils {
	/**
	 * 获取一个32位的随机数 16位数字组成。并去掉“-”并且转换为大写
	 * 
	 */
	public static String getUUIDRandomNum() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
}
