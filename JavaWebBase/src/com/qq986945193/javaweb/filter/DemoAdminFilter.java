package com.qq986945193.javaweb.filter;
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 *管理员的一个过滤器 
 */
public class DemoAdminFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/**
		 * 判断session域中是否存在 admin（管理员权限）,如果存在，则进行放行，否则进行拦截
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		if (session.getAttribute("admin_session")!=null) {
			chain.doFilter(request, response);
			return;
		}else {
			req.setAttribute("msg", "请用管理员账号登陆");
			req.getRequestDispatcher("/demo/userfilter/login.jsp").forward(request, response);
		}
		
		
		
		
		
		
	
	
	
	
	
	}

	@Override
	public void destroy() {
		
	}

}
