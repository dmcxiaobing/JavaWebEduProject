package com.qq986945193.javaweb.servlet.day09.servlet01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
/*
 * 测试我们自己写的GenericServlet
 */
public class CheckGenericServlet extends GenericServlet {
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("我是CheckGenericServlet");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String string = getInitParameter("woshiCheckGenericServlet");
		System.out.println(string);
	}
}
