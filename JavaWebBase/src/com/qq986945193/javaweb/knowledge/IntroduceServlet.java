package com.qq986945193.javaweb.knowledge;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.ByteArrayOutputStream;

/**
 * Servlet的一些常用方法 简介
 *
 */
public class IntroduceServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// openDownloadFile(req, resp);
		setHeadergzip(req, resp);
	}

	/**
	 * 利用请求头设置压缩格式为gzip
	 */
	private void setHeadergzip(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 这里假如是返回客户端的数据，当然若是数据量小不用使用压缩格式，大数据使用
		String data = "hello servlet";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		GZIPOutputStream gout = new GZIPOutputStream(baos);
		// 包装流一般有缓冲
		gout.write(data.getBytes());
		// 为确保有数据 刷新后关闭
		gout.flush();
		gout.close();
		byte[] gzip = baos.toByteArray();
		// 告知客户机使用的压缩格式
		response.setHeader("Content-Encoding", "gzip");
		response.setHeader("Content-Length", gzip.length + "");

		response.getOutputStream().write(gzip);

	}

	/**
	 * 设置请求头，以下载的方式打开文件
	 */
	private void openDownloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 这里filename格式可以根据tomcat中的conf来写
		response.setHeader("content-disposition", "attachment;filename=google.jpeg");
		// 得到图片的输入流 然后利用输出流写出
		InputStream iStream = this.getServletContext().getResourceAsStream("/imgs/google_android.jpg");
		int len = 0;
		byte[] datas = new byte[1024];
		OutputStream oStream = response.getOutputStream();
		while ((len = iStream.read(datas)) != -1) {
			oStream.write(datas, 0, len);
			oStream.flush();
		}
		oStream.close();
		iStream.close();
	}
}
