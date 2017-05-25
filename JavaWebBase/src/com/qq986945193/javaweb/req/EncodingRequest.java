package com.qq986945193.javaweb.req;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 一个编码转换的工具类，防止乱码
 */
public class EncodingRequest extends HttpServletRequestWrapper{

	/**
	 * 需要转换的编码
	 */
	private String charset = "";
	public EncodingRequest(HttpServletRequest request,String charset) {
		super(request);
		this.charset = charset;
	}
	/**
	 * 根据请求方式，进行转码防止乱码
	 */
	public String getParameter(String name){
		HttpServletRequest request = (HttpServletRequest) getRequest();
		/**
		 * 得到请求方式
		 */
		String method = request.getMethod();
		if (method.equalsIgnoreCase("post")) {
			try {
				request.setCharacterEncoding(charset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else if (method.equalsIgnoreCase("get")) {
			//get请求获取参数
			String value = request.getParameter(name);
			try {
				value = new String(name.getBytes("ISO-8859-1"),charset);
			
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return value;
		}
		
		return request.getParameter(name);
	}
	
}
