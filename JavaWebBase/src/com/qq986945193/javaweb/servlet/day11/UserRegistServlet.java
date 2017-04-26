package com.qq986945193.javaweb.servlet.day11;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq986945193.javaweb.domain.UserBean;
import com.qq986945193.javaweb.exception.UserException;
import com.qq986945193.javaweb.service.UserService;
import com.qq986945193.javaweb.utils.CommonUtils;
import com.qq986945193.javaweb.utils.PathUtils;

public class UserRegistServlet extends HttpServlet {
	public static String XML_PATH = "src/user.xml";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// servlet依赖业务层 即service层
		UserService userService = new UserService();
		// 将获取到的参数封装到javabean对象中
		UserBean userBean = CommonUtils.toBean(request.getParameterMap(), UserBean.class);
		/**
		 * 添加新任务(表单提交)
		 * 1，创建一个map，用来装在所有的表单错误信息。在校验过程中如果失败，则向map添加错误信息，其中key为表单字段内容
		 * 2，校验之后，查看map长度是否大于0，如果大于0则表示有错误信息，然后将错误信息保存保存到map中转发到register.jsp
		 * 3，如果map为空，说明没有错误信息，则向下执行。
		 */
		Map<String, String> errors = new HashMap<String, String>();
		if (userBean.getUsername() == null || userBean.getUsername().trim().isEmpty()) {
			errors.put("username", "用户名不能为空");
		}
		if (userBean.getPassword() == null || userBean.getPassword().trim().isEmpty()) {
			errors.put("password", "密码不能为空");
		}
		if (userBean.getVerifycode() == null || userBean.getVerifycode().trim().isEmpty()) {
			errors.put("verifyCode", "验证码不能为空");
		} else if (!userBean.getVerifycode()
				.equalsIgnoreCase((String) request.getSession().getAttribute("verifycode"))) {
			errors.put("verifyCode", "验证码不正确");
		}
		/**
		 * 判断map是否为空,如果不为空，则说明存在错误
		 */

		if (errors != null && errors.size() > 0) {
			/**
			 * 将errors保存到request域并转发到regist.jsp
			 */
			request.setAttribute("errors", errors);
			// 将用户输入过的信息保存到request域
			request.setAttribute("user", userBean);
			request.getRequestDispatcher("/jsps/userRegist.jsp").forward(request, response);
			;
			return;
		}

		/**
		 * 如果注册成功，这里显示去登陆。 如果注册失败，则转发到register页面，并将错误信息，转发到request域
		 */
		XML_PATH = PathUtils.getClassesPath(UserRegistServlet.class) + "user.xml";
		System.out.println("XML_PATH：" + XML_PATH);
		try {
			userService.regist(userBean);
			response.getWriter()
					.write("<h1>注册成功<h1/><a href = '" + request.getContextPath() + "/jsps/userlogin.jsp" + "'>点击这里去登陆</a>");
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", userBean);
			request.getRequestDispatcher("/jsps/userRegist.jsp").forward(request, response);
		}

	}

}
