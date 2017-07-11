package com.qq986945193.javaweb.servlet.demo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq986945193.javaweb.domain.DemoBook;
import com.qq986945193.javaweb.service.DemoBookService;
import com.qq986945193.javaweb.servlet.BaseServlet;

/**
 * 测试一个缓存html的控制层
 */
public class DemoBookServlet extends BaseServlet {
	private DemoBookService bookservice = new DemoBookService();

	public String findAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		List<DemoBook> lists = bookservice.findAll();
		req.setAttribute("bookList", lists);
		return "f:/demo/book/show.jsp";
	}

	public String findByCid(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		String cid = req.getParameter("cid");
		List<DemoBook> lists = bookservice.findByCid(cid);
		req.setAttribute("bookList", lists);
		return "f:/demo/book/show.jsp";
	}
}
