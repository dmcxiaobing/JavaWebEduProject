package com.qq986945193.javaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.qq986945193.javaweb.request.EncodingRequest;

/**
 * 解决全站的字符编码乱码
 */
public class EncodingFilter implements Filter
{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/**
		 * 设置编码最好设置在web.xml中，配置filter的initParameter()参数和值，这里为了方便，直接写了
		 */
		String charset = "utf-8";
		response.setCharacterEncoding(charset);
		response.setContentType("text/html;charset="+charset);
		/**
		 * 掉包我们自己设置的response和request
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		EncodingRequest encodingRequest = new EncodingRequest(req, charset);
		//最后放行
		chain.doFilter(encodingRequest, response);
	
	
	}

	@Override
	public void destroy() {
	}


}
