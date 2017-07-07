package com.qq986945193.javaweb.servlet.demo;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq986945193.javaweb.servlet.BaseServlet;

/**
 * 测试一个权限的servlet。用户和管理员和游客
 */
public class DemoUserFilterLoginServlet extends BaseServlet {

	/**
	 * 登陆的方法
	 */
	
	/*
	 * 1. 获取用户名
	 * 2. 判断用户名中是否包含user
	 *   3. 如果包含，就是普通会员
	 *   4. 如果包含admin，就是管理员
	 * 5. 要把登录的用户名称保存到session中
	 * 6. 转发到index.jsp
	 */
	public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		if (username != null && !username.trim().isEmpty()) {
			if (username.equals("user")) {
				req.getSession().setAttribute("user_session", username);
				return "f:/demo/userfilter/users/u.jsp";
			} else if (username.equals("admin")) {
				req.getSession().setAttribute("admin_session", username);
				return "f:/demo/userfilter/admin/a.jsp";
			}
		} else {
			req.setAttribute("msg", "用户名不能为空");
			return "f:/demo/userfilter/login.jsp";
		}
		return "f:/demo/userfilter/login.jsp";
	}
}
