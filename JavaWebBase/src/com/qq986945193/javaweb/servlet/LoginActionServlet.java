package com.qq986945193.javaweb.servlet;

/**
 * 这是一个登陆的功能，返回json数据  
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;

import com.qq986945193.javaweb.domain.day12.LoginActionServletBean;
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
public class LoginActionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理客户端的post以及get请求
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username" + username + "," + "password" + password);
		PrintWriter writer = response.getWriter();
		if (username.equals("admin") && password.equals("123456")) {
			// 这里简单表示登陆成功
			LoginActionServletBean bean = new LoginActionServletBean();
			bean.setResultCode(1);
			bean.setResultMsg("success");
			HashMap<String, LoginActionServletBean> map = new HashMap<String, LoginActionServletBean>();
			map.put("result", bean);
			// 这里使用json转换jar包，所依赖commons-beanutis Commons-collections
			// commons-lang commondlogging ezmorph
			String jsonValue = JSONSerializer.toJSON(map).toString();
			writer.print(jsonValue);
		}
		if (writer != null) {
			writer.flush();
			writer.close();
		}

	}
}
