package com.qq986945193.javaweb.servlet.day09.servlet01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
 * 模拟GenericServlet
 * */
public class GenericServlet implements Servlet {
	protected ServletConfig config;
	/**
	 * 它是由服务器调用的，并且只调用一次
	 * 它是生命周期中第一个调用的，只调用一次
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 把服务器传递的Servletconfig赋值给本类的一个成员，其实就是把它保存起来，方便在其他方法中使用！
		this.config = config;
		init();
	}
	
	/**
	 * 我们自己可以定义一个 方法进行初始化。然后由子类进行调用
	 */
	protected void init() {
		System.out.println("我是自己写的GenericServlet");
	}
	/**
	 * 由于init(ServletConfig config)必定是第一个调用的，所以我们这里可以返回
	 * 
	 */
	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		/*
		 * 这里也是可以使用ServletConfig的成员
		 */
		System.out.println("每次处理请求都会被调用！");
	}
	/**
	 * 获取servlet的信息
	 */
	@Override
	public String getServletInfo() {
		return "模仿genericservlet";
	}
	/**
	 * 当服务器关闭之前调用一次
	 */
	@Override
	public void destroy() {
		System.out.println("我是destroy()");
	}
	/**
	 * 自己模仿写，返回servletName
	 */
	public String getServletName() {
		return this.config.getServletName();
	}
	/**
	 * 自己模仿写，返回servletContext的信息
	 */
	public ServletContext getServletContext() {
		return this.config.getServletContext();
	}
	/**
	 * 返回servlet中的初始化内容
	 */
	public String getInitParameter(String name) {
		return this.config.getInitParameter(name);
	}
}
