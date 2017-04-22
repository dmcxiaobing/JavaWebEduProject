package com.qq986945193.javaweb.servlet.day11;
/**
 * 
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq986945193.javaweb.utils.VerifyCodeUtils;

/**
 * 生成图片验证的功能展示
 */
public class VerifyCodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1，生成验证码图片，然后保存到session域中,为了以后和用户输入的进行对比。2,发送给客户端
		 */
		VerifyCodeUtils verficaoCodeUtils = new VerifyCodeUtils();
		BufferedImage BufferedImage = verficaoCodeUtils.getImage();
		// 将验证码的文字保存到session域中
		request.getSession().setAttribute("verifycode", verficaoCodeUtils.getText());
		System.out.println(request.getSession().getAttribute("verifycode"));
		// 将图片输入到浏览器
		VerifyCodeUtils.output(BufferedImage, response.getOutputStream());
	}

}
