package com.qq986945193.javaweb.service;

import java.util.List;

import com.qq986945193.javaweb.dao.DemoCustomerDao;
import com.qq986945193.javaweb.domain.DemoCustomerBean;
/**
 * 客户管理系统的业务层
 */
public class DemoCustomerService {
	private DemoCustomerDao dao = new DemoCustomerDao();
	/**
	 * 添加客户
	 * @param customerBean 要存入数据库的bean
	 */
	public void add(DemoCustomerBean customerBean) {
		dao.add(customerBean);
	}
	/**
	 * 查询所有客户
	 */
	public List<DemoCustomerBean> findAll() {
		return dao.findAll();
	}
	/**
	 * 根据cid查询出客户信息
	 */
	public DemoCustomerBean findByCid(String cid) {
		return dao.findByCid(cid);
	}
	/**
	 * 编辑客户信息之后的保存操作
	 * @param customerBean 用户输入的信息
	 */
	public void editSave(DemoCustomerBean customerBean) {
		dao.editSave(customerBean);
	}
	/**
	 * 高级搜索，根据条件进行搜索客户
	 */
	public List<DemoCustomerBean> query(DemoCustomerBean customerBean) {
		return dao.query(customerBean);
	}

}
