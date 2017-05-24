package com.qq986945193.javaweb.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *这是一个统计网页访问数量的listener，实现ServletContextListener
 *在tomcat服务器启动的时候，创建一个map集合。 listener需要在web.xml配置 
 */
public class CountSumListener implements ServletContextListener{

	/**
	 * 在服务器启动时创建map,保存到ServletContext中
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//创建map，以ip地址为键，访问数量为值
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//得到ServletContext对象
		ServletContext application = sce.getServletContext();
		//将map对象保存到application中
		application.setAttribute("map", map);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
