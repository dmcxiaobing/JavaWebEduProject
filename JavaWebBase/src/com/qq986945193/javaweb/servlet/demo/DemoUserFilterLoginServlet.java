package com.qq986945193.javaweb.servlet.demo;

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
