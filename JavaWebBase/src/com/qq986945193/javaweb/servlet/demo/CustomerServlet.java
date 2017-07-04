package com.qq986945193.javaweb.servlet.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq986945193.javaweb.domain.DemoCustomerBean;
import com.qq986945193.javaweb.service.DemoCustomerService;
import com.qq986945193.javaweb.servlet.BaseServlet;
import com.qq986945193.javaweb.utils.CommonUtils;
import com.qq986945193.javaweb.utils.GetUUIDRandomUtils;

/**
 * 客户关系管理系统 controller
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
	 * 编辑客户
	 *  编辑之前的加载工作
	 */
	public String preEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		System.out.println("cid"+cid);
		//根据cid查出客户信息
		DemoCustomerBean customerBean = customerService.findByCid(cid);
		request.setAttribute("cstm", customerBean);
		return "f:/demo/customer/jsps/edit.jsp";
	}
	/**
	 * 编辑之后的保存操作
	 */
	public String editSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
}
