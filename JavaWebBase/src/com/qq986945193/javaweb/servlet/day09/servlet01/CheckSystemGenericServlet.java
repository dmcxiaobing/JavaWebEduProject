package com.qq986945193.javaweb.servlet.day09.servlet01;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
/*
 * 继承系统的GenericServlet，查看生命周期的方法   注：这里init只是一个提取配置的方法
 * */
public class CheckSystemGenericServlet extends GenericServlet {

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.err.println("我是系统genericServlet的子类 init方法");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.err.println("我是系统genericServlet的子类  service方法");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.err.println("我是系统genericServlet的子类  destroy方法");
	}
	
}
