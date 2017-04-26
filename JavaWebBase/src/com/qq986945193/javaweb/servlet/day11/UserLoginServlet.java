package com.qq986945193.javaweb.servlet.day11;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq986945193.javaweb.domain.UserBean;
import com.qq986945193.javaweb.exception.UserException;
import com.qq986945193.javaweb.service.UserService;
import com.qq986945193.javaweb.utils.CommonUtils;
/**
 * 用户注册后，进行登录
 */
public class UserLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		/**
		 * 依赖业务层 service
		 */
		UserService userService = new UserService();
		UserBean formUserBean = CommonUtils.toBean(request.getParameterMap(), UserBean.class);
		
		try {
			
			UserBean userBean = userService.login(formUserBean);
			/**
			 * 如果登陆成功，则将userbean的信息保存到session域中，以供后续使用
			 */
			request.getSession().setAttribute("sessionUser", userBean);
			//重定向欢迎页面
			response.sendRedirect(request.getContextPath()+"/jsps/userwelcome.jsp");
		} catch (UserException e) {
			/**
			 * 如果登陆失败，可以转发到继续登陆的界面 将错误信息和user对象保存到request域
			 */
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", formUserBean);
			request.getRequestDispatcher("/jsps/userlogin.jsp").forward(request, response);
			
		}
	
	}

}
