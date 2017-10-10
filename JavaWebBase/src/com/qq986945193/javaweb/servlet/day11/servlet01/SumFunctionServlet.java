package com.qq986945193.javaweb.servlet.day11.servlet01;

/**
 * 两个整数进行加法运算 计算出结果后进行跳转到结果页jsp
 */
import java.io.IOException;
import java.io.PrintWriter;

//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
public class SumFunctionServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 先取出输入的内容
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		// 进行不判断，不为空进行算法。
		if (num1 != null && !num1.equals("") && num2 != null & !num2.equals("")) {
			Integer int1 = Integer.parseInt(num1);
			Integer int2 = Integer.parseInt(num2);
			Integer sum = int1 + int2;
			// 把结果保存到request域中
			request.setAttribute("sum", sum);
			// 转发到运算结果的jsp中
			request.getRequestDispatcher("/day11cookie和session/sumnum.jsp")
					.forward(request, response);

		} else {
			response.getWriter().print("请填写数字");
			return;
		}

	}

}
