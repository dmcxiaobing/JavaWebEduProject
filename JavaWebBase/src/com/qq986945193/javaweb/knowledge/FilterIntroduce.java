package com.qq986945193.javaweb.knowledge;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Filter过滤器的使用详解 filter也是需要注册的。
 * 
 * 
 */
/*
 * <filter> 
 * <filter-name>FilterIntroduce</filter-name>
 * <filter-class>com.qq986945193.javaweb.knowledge.FilterIntroduce</filter-class>
 *  </filter>
 * <filter-mapping>
 *  <filter-name>FilterIntroduce</filter-name>
 *  //过滤的类型。这样表示只过滤ServletDemo
 * <url-pattern>/ServletDemo</url-pattern> 
 *	//过滤转发，这里可以选择 include forward request（默认的） error
 * <dispatcher>FORWARD</dispatcher>
 * </filter-mapping>
 */
public class FilterIntroduce implements Filter {
	/**
	 * 创建之后，马上执行，用来做初始化
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	/**
	 * 每次过滤时都会执行
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// System.out.println("start filter");
		// chain.doFilter(request, response); 放行
		// System.out.println("end fileter");
	}

	/**
	 * 销毁之前执行，用来对非内存资源金兴食坊
	 */
	@Override
	public void destroy() {

	}

}
