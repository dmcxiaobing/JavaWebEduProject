package com.qq986945193.javaweb.filter;
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq986945193.javaweb.response.StaticResponse;
/**
 * 这是一个将jsp页面缓存到html中的filter
 */
public class StaticFilter implements Filter {
	private FilterConfig config;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/**
		 * 第一次访问时，查找请求对应的html页面是否存在，如果存在则重定向到html，
		 * 如果不存在，则放行。并且把servlet访问数据库后的数据输出到客户端保存到html文件中。
		 * 再重定向html中
		 */
		/**
		 * 1，获取cid参数。cid有四种可能。因为这里是有专门的测试四个数据
		 * 2，null  null.html  查询所有
		 * 	 1,1.html 查询SE
		 *   2,2.html 查询EE
		 *   3,3.html 查询Framework
		 *   html页面的保存路径为 htmls目录下。
		 *   
		 *   
		 */
		HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String cid = req.getParameter("cid");
		String htmlPage = cid+".html";//得到对应的文件名称
		//得到文件的存放目录
		String htmlPath = config.getServletContext().getRealPath("/demo/book/htmls");
		File destFile = new File(htmlPath,htmlPage);
		if (destFile.exists()) {
			//如果文件存在 则直接重定向到这个文件
			res.sendRedirect(req.getContextPath()+"/demo/book/htmls/"+htmlPage);
			return;
		}
		//如果这个文件不存在。我们这里需要生成html，
		/**
		 * 1，放行，show.jsp会做很多的输出，我们不要让他输入到客户端，直接让他输出到指定的html页面上
		 * 完成。调包response。让他的getWriter()与一个html文件绑定。name，show.jsp输出就到了html文件中
		 */
		StaticResponse response2 = new StaticResponse(res,destFile.getAbsolutePath());
		chain.doFilter(request, response2);//放行，即生成了html文件
		//这是页面已经存在，则重定向html文件
		res.sendRedirect(req.getContextPath()+"/demo/book/htmls/"+htmlPage);
	}

	@Override
	public void destroy() {

	}

}
