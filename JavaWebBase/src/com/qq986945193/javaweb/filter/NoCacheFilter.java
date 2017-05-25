package com.qq986945193.javaweb.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpFilter;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

/**
 * 这是一个禁用缓存的filter，这里没有配置在web.xml中，需要的话可以配置。但是可能部分浏览器不兼容， 所以就需要自己处理了。
 */
public class NoCacheFilter extends HttpFilter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.doFilter(request, response, chain);
		response.setHeader("cache-control", "no-cache");
		response.setHeader("pragma", "no-cache");
		response.setHeader("expires", "0");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
