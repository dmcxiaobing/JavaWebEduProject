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
 * Servlet的一些常用方法 简介 介绍
 * 
 * 在Servlet中可以很方便的获取各种运行环境信息，这些信息包括Servlet自身信息、服务器端信息和客户端信息三类。
 1. 获取Servlet自身信息
Servlet自身信息主要是指在web.xml文件中的配置信息，包括初始化参数和配置名称等，通过javax.serlet.ServletConfig接口定义的方法获取。
·             获取初始化参数
所谓的获取初始化参数即获得web.xml配置文件中<servlet>元素下子元素<init-param>子元素的相关设置，这些信息的获得是在Servlet生命周期中的初始化阶段完成。参数的获得可以通过getInitParameter(String name)方法获得，其中方法中的参数name为<init-param>子元素中定义的参数名称，返回值为该子元素中设置的初始值。因为在 GenericServlet中实现了ServletConfig接口，因此在其子类中可以直接调用getInitParameter（）方法。
另外，getParameterNames（）方法可以返回初始化参数名称的一个集合，返回类型为Enumeration
·             获取Servlet配置名称
获得Servlet在web.xml配置文件中配置名称getServletName（），返回类型为String，与getInitParameter（）方法类似，可以在子类中直接使用该方法。
 2.获取服务器端信息
在Servlet中可以很方便的获取正在执行它的服务器的信息，例如站点名称、监听端口、Servlet软件名称和版本、Servlet容器属性等。这些信息的获取是通过ServletContext和ServletRequest接口提供的方法实现的。
ServletRequest
String getServerName（）
获取服务器的站点名称
int getServerPort（）
获取服务器的监听端口号
ServletContext
String getServerInfo（）
获取服务器的名称和版本
Enumeration getAttributeNames()
获取服务器所有的属性名称
Object getAttribute（String name）
按名称获取服务器的属性值
int getMajorVersion（）
服务器支持的Servlet主版本号
int getMinorVersion（）
服务器支持的Servlet次版本号
 3.获取客户端信息
客户请求的相关信息存储在ServletRequest对象中，获取客户端信息主要是通过调用ServletRequest接口或者子接口HttpRequest提供的方法。
String getRemoteHost()
获取客户端主机名
String getRomoteAddr()
获取客户端IP地址
int getRemotePort()
获取客户端端口号
String getProtocol()
获取客户端请求协议
String getCharacterEncoding()
获取客户请求的编码方式
Enumeration getParameterNames()
获取客户端发送的所有请求参数名称
String getParameter(String name)
获取name指定的参数值

 *
 */
public class IntroduceServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setCharsetEncode(request, response);

		// openDownloadFile(req, resp);
		// setHeadergzip(req, resp);
		// setRequestDispather(req, resp);
		// introduceCookie(req, resp);
		// introduceHttpSession(request, response);
		response.setHeader("refresh", "1");

	}

	/**
	 * 设置编码
	 */
	private void setCharsetEncode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码，处理中文乱码的问题
//		response.setCharacterEncoding("utf-8");
//		request.setCharacterEncoding("utf-8");
		//告诉浏览器是utf-8的编码
//		response.setHeader("Content-type", "text/html;charset=utf-8");
//		response.getOutputStream().write("你好程序员".getBytes("utf-8"));
//		response.setHeader("content-type", "text/html;charset=utf-8");
		/**
		 * 一般设置这两个即可。
		 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.getOutputStream().write("你好程序员".getBytes("utf-8"));
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		this.doGet(req, resp);
	}
}
