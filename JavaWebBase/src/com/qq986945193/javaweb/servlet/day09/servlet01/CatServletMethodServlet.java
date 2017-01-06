package com.qq986945193.javaweb.servlet.day09.servlet01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
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
/**
 * 查看servlet接口中的方法
 * 
 * servlet的生命周期方法只有三个：init() service() destroy();
 */
public class CatServletMethodServlet  implements Servlet{
	/**
	 * 初始化 首次创建servlet的时候使用 并且只会执行一次
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()调用了");
		/**
		 * 获取初始化参数 即(init-param)中的value的值
		 */
		System.out.println(config.getInitParameter("CatServletMethodServlet"));
		/**
		 * 获取初始化参数的所有的(init-param)name的值
		 */
		Enumeration<String> initParameterNames = config.getInitParameterNames();
		while (initParameterNames.hasMoreElements()) {
			String string = (String) initParameterNames.nextElement();
			System.out.println("我是while循环中的"+string);
		}
	}
	/**
	 * 获取servlet的配置信息
	 */
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("service()用了");
		return null;
	}
	/**
	 * 执行servlet中的请求 会执行多次，每次处理请求均是调用此方法
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("service()用了");
		
	}
	/**
	 * 返回servlet的信息 一般不用。
	 */
	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo()...");
		return "我是一个查看servlet接口中的方法的servlet";
//		return null;
	}
	/**
	 * 销毁servlet  关闭服务器时调用 只会调用一次
	 */
	@Override
	public void destroy() {
		System.out.println("destroy()...");
	}

}
