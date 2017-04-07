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
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.output.ByteArrayOutputStream;

/**
 * Servlet的一些常用方法 简介
 *
 */
public class IntroduceServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码，处理中文乱码的问题
		req.setCharacterEncoding("utf-8");
		
		// openDownloadFile(req, resp);
		// setHeadergzip(req, resp);
		// setRequestDispather(req, resp);
		// introduceCookie(req, resp);
		introduceHttpSession(req, resp);

	}

	/**
	 * session的一些简单用法. 具体来说cookie机制采用的是在客户端保持状态的方案，而session机制采用的是在服务器端保持状态的方案。
	 */
	private void introduceHttpSession(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();// [获取session对象]
		session.setAttribute("username", "username");// [在session中保存用户名]
		// 让session失效
		session.invalidate();
		// 一秒后session就会被移除
		session.setMaxInactiveInterval(1);
		response.sendRedirect("/index.jsp");// [重定向到index1.jsp]
	}

	/**
	 * Cookie的一些操作方法
	 */
	private void introduceCookie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// cookie的name和value均不能使用中文，若使用中文先用URLEncoder.encode()编码，然后使用URLDecode.URLDecoder.decode()解码
		// 创建cookie对象，值为当前时间
		Cookie cookieOne = new Cookie("lasttime", new Date().toString());
		// 设置cookie的有效时间为1小时,默认关闭浏览器消失
		cookieOne.setMaxAge(60 * 60);
		// 设置一个cookie的路径
		// cookieOne.setPath("/jsp");
		response.addCookie(cookieOne);
		// 可以根据根据时间进行判断，用户是首次进入网站
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				System.err.println(cookie.getValue());
			}
		}

	}

	/**
	 * 请求转发或请求包含等方法
	 */
	private void setRequestDispather(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 请求转发
		// request.getRequestDispatcher("/index.jsp").forward(request,
		// response);
		// 请求包含
		request.setAttribute("name", "introduce");
		response.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/jsp/introduce.jsp").include(request, response);

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
