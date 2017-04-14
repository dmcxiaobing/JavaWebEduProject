package com.qq986945193.javaweb.servlet.day11;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆的一个小功能,利用cookie和session
 *
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		if (username == null || username.equals("")) {
			// 如果输入的用户名为null,则提示一下
			request.setAttribute("msg", "用户名不能为空");
			// 转发到登陆界面  因为要传入错误信息，所以这里使用转发
			 request.getRequestDispatcher("/day11cookieandsession/login.jsp").forward(request,
			 response);				
//			response.sendRedirect(getServletContext().getContextPath()+"/day11cookieandsession/login.jsp");
		} else {
			if (username.equalsIgnoreCase("java")) {
				// 这里假如如果用户名为java代表登陆成功。
				// 这里直接利用cookie的构造方法，将用户名保存到cookie中，这样以后可以直接拿来用
				Cookie cookie = new Cookie("username", username);
				cookie.setMaxAge(24 * 60 * 60);// 设置存活时间为一天
				//添加cookie
				response.addCookie(cookie);
				
				// 设置一下session，这样如果用户没有登陆或者长时间没有变化，无法进入后台
				HttpSession sHttpSession = request.getSession();
				sHttpSession.setAttribute("username", username);
				// 登陆成功后，转发到登陆成功的jsp
//				request.getRequestDispatcher("/day11cookieandsession/success.jsp").forward(request, response);
				// response.getWriter().write("欢迎"+username+"登录系统");
				//登陆成功后重定向success
				response.sendRedirect(this.getServletContext().getContextPath()+"/day11cookieandsession/success.jsp");
			} else {
				// 用户名错误，告知用户并转发至登录界面
				request.setAttribute("msg", "用户名错误，正确用户名是java");
				request.getRequestDispatcher("/day11cookieandsession/login.jsp").forward(request, response);
			}
		}
	}

}
