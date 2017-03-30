package com.qq986945193.javaweb.knowledge;

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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet的一些常用方法 简介
 *
 */
public class IntroduceServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		openDownloadFile(req, resp);
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
