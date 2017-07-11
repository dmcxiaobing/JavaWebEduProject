package com.qq986945193.javaweb.response;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 将jsp页面输出到html页面中
 *
 */
public class StaticResponse extends HttpServletResponseWrapper {
	private PrintWriter pWriter;

	/**
	 * @param path
	 *            html文件路径
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	public StaticResponse(HttpServletResponse response, String path)
			throws FileNotFoundException, UnsupportedEncodingException {
		super(response);
		// 创建一个与html文件路径在一起的流对象
		pWriter = new PrintWriter(path, "utf-8");
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		// 返回一个与html绑定在一起的printWriter对象
		// jsp会使用它进行输出，这样数据就都输出到html文件了
		return pWriter;
	}
}
