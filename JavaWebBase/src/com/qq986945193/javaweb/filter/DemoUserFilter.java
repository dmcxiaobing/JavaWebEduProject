package com.qq986945193.javaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.qq986945193.javaweb.servlet.LoginActionServlet;
/**
 * 用户过滤的filter，判断是否登录，是一个用户
 */
public class DemoUserFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/**
		 * 1，得到session，判断session域中是否存在admin(管理员权限),若是存在放行
		 * 2,判断session域中是否存在username(普通用户),如果存在，放行，否则转发到login.jsp，并告知原因
		 */

		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		if (session.getAttribute("admin_session")!=null) {
			chain.doFilter(request, response);
			return;
		}
		if (session.getAttribute("user_session")!=null) {
			chain.doFilter(request, response);
			return;
		}
		//下面就是没有登陆的状态了。
		req.setAttribute("msg", "请先登陆后，在再进行访问其他页面");
		req.getRequestDispatcher("/demo/userfilter/login.jsp").forward(request, response);
	
	
	}

	@Override
	public void destroy() {
	}

}
