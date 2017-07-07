package com.qq986945193.javaweb.servlet.demo;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq986945193.javaweb.domain.DemoCustomerBean;
import com.qq986945193.javaweb.domain.DemoPageBean;
import com.qq986945193.javaweb.service.DemoCustomerService;
import com.qq986945193.javaweb.servlet.BaseServlet;
import com.qq986945193.javaweb.servlet.day10.servlet02.GetUrlInfoServlet;
import com.qq986945193.javaweb.utils.CommonUtils;
import com.qq986945193.javaweb.utils.GetUUIDRandomUtils;

/**
 * 客户关系管理系统 controller
 * 
 */
/**
 * 
 * CREATE DATABASE IF NOT EXISTS customers; USE customers;
 * 
 * CREATE TABLE t_customer( cid CHAR(32) PRIMARY KEY, cname VARCHAR(40) NOT
 * NULL, gender VARCHAR(6) NOT NULL, birthday CHAR(10), cellphone VARCHAR(15)
 * NOT NULL, email VARCHAR(40), description VARCHAR(500) );
 * 
 * SELECT * FROM t_customer;
 *
 */
public class CustomerServlet extends BaseServlet {
	private DemoCustomerService customerService = new DemoCustomerService();

	/**
	 * 添加客户
	 */
	public String add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * 使用DemoCustomerBean封装表单数据 补全cid; 使用service方法完成添加工作。
		 * 像request域中保存成功信息。转发到msg.jsp
		 */
		DemoCustomerBean customerBean = CommonUtils.toBean(req.getParameterMap(), DemoCustomerBean.class);
		customerBean.setCid(GetUUIDRandomUtils.getUUIDRandomNum());
		System.out.println(customerBean);
		customerService.add(customerBean);
		req.setAttribute("msg", "恭喜您，添加客户成功");
		return "f:/demo/customer/jsps/msg.jsp";
	}

	/**
	 * 查询客户
	 */
	public String findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<DemoCustomerBean> lists = customerService.findAll();
		req.setAttribute("cstmList", lists);
		return "f:/demo/customer/jsps/list.jsp";
	}

	/**
	 * 编辑客户 编辑之前的加载工作
	 */
	public String preEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		System.out.println("cid" + cid);
		// 根据cid查出客户信息
		DemoCustomerBean customerBean = customerService.findByCid(cid);
		request.setAttribute("cstm", customerBean);
		return "f:/demo/customer/jsps/edit.jsp";
	}

	/**
	 * 编辑之后的保存操作
	 */
	public String editSave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 得到用户提交的信息，然后进行更新数据库
		 */
		DemoCustomerBean customerBean = CommonUtils.toBean(request.getParameterMap(), DemoCustomerBean.class);
		customerService.editSave(customerBean);
		request.setAttribute("msg", "修改成功");
		return "f:/demo/customer/jsps/msg.jsp";

	}

	/**
	 * 高级搜索，根据条件进行搜索客户
	 */
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 得到用户提交的信息，然后根据条件进行搜索客户
		 */
		DemoCustomerBean customerBean = CommonUtils.toBean(request.getParameterMap(), DemoCustomerBean.class);
		List<DemoCustomerBean> lists = customerService.query(customerBean);
		request.setAttribute("cstmList", lists);
		return "f:/demo/customer/jsps/list.jsp";

	}

	/**
	 * 分页查询客户
	 */
	public String findByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = GetUrl(request);
		/**
		 * 首先获取到当前的页码，pc（pageCode）
		 */
		int pc = getPc(request);
		// 这里每页的记录数，直接写为10
		int ps = 10;
		DemoPageBean<DemoCustomerBean> pageBean = customerService.findByPage(pc, ps);
		pageBean.setUrl(url);
		request.setAttribute("pb", pageBean);
		return "f:/demo/customer/jsps/pageList.jsp";
	}

	/**
	 * 高级搜索查询，带有分页 高级组合查询
	 */
	public String pageQuery(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1，获取pc，如果pc不存在，则设置pc当前页为1 2，获取url，如果url（方法参数）中包含了&pc=，name截掉它
		 */
		int pageCode = getPc(request);

		String url = GetUrl(request);
		// 获取表单数据
		DemoCustomerBean formCustomerBean = CommonUtils.toBean(request.getParameterMap(), DemoCustomerBean.class);
		/**
		 * 获取总记录数tr
		 */
		int tr = customerService.pageCountQuery(formCustomerBean);
		// 设置每页显示的记录数
		int ps = 10;
		DemoPageBean<DemoCustomerBean> pageBean = new DemoPageBean<DemoCustomerBean>();
		pageBean.setPs(ps);
		pageBean.setTr(tr);
		pageBean.setPc(pageCode);
		pageBean.setUrl(url);
		/**
		 * 获取datas,即当前页记录 .从第几条记录查询，一共查询多少条记录
		 */
		List<DemoCustomerBean> datas = customerService.queryByPage(formCustomerBean, pageBean.getIndex(), ps);
		pageBean.setDatas(datas);

		request.setAttribute("pb", pageBean);
		// 转发jsp
		return "f:/demo/customer/jsps/pageList.jsp";
	}

	/**
	 * 截取url
	 */
	private String GetUrl(HttpServletRequest request) {
		// 获取请求的参数
		// http://localhost/test.do?a=b&c=d&e=f
		// 通过request.getQueryString()得到的是
		// a=b&c=d&e=f
		System.out.println("geturl");
		/**
		 * 如果url中存在pc,则需要把pc截取下去，不要它
		 */
		String url = request.getQueryString();
		System.out.println("url:" + url);
		int index = url.lastIndexOf("&pc=");
		// 如果等于-1则说明不存在
		if (index == -1) {
			return url;
		}
		return url.substring(0, index);
	}

	/**
	 * 获得当前的页码 如果为null，默认为第一页，
	 */
	private int getPc(HttpServletRequest request) {
		String pc = request.getParameter("pc");
		if (pc != null && !pc.trim().isEmpty()) {
			return Integer.parseInt(pc);
		} else {
			return 1;
		}
	}

}
