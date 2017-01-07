package com.qq986945193.javaweb.servlet.day09.servlet02;

/**
 * 获取web.xml中配置的context-param
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
public class GetContextValueServlet extends HttpServlet {

	/**
	 * 根据ServletContext对象获取到context-param的值
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext mContext = this.getServletContext();
		String string = mContext.getInitParameter("context-param");
		System.out.println("doget" + string);
	}


}
