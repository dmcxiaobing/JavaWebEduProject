package com.qq986945193.javaweb.filter;

/**
 * http://weibo.com/mcxiaobing
 */
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 统计网页访问数量的filter
 */
public class CountSumFilter implements Filter {
	/**
	 * 通过filterConfig的get***()方法可以获得ServletContext等对象
	 */
	private FilterConfig filterConfig;

	/**
	 * 在服务器启动时就会执行本方法，而且本方法只会执行一次
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/**
		 * 通过filterConfig获取到ServletContext对象。然后获取到application中的map对象
		 */
		ServletContext application = filterConfig.getServletContext();
		HashMap<String, Integer> hashMap = (HashMap<String, Integer>) application.getAttribute("map");
		/**
		 * 通过request对象获取到用户的ip
		 */
		String ip = request.getRemoteAddr();
		/**
		 * 然后进行判断，这个客户端ip是否在map中存在，如果不存在说明是第一次，否则直接获取到数量加1
		 */
		if (hashMap.containsKey(ip)) {
			int count = hashMap.get(ip);
			hashMap.put(ip, count + 1);
		} else {// 这里说明不存在，是第一次访问
			hashMap.put(ip, 1);
		}
		// 然后再将hashmap放回到application中
		application.setAttribute("map", hashMap);

		/**
		 * 最后放行，然后在一个jsp页面，显示数量
		 */
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {

	}

}
