package com.qq986945193.javaweb.demo;

import org.junit.Test;

import com.qq986945193.javaweb.domain.DemoCustomerBean;
import com.qq986945193.javaweb.service.DemoCustomerService;
import com.qq986945193.javaweb.utils.GetUUIDRandomUtils;

/**
 * 往客户表数据库添加大量数据，用来测试分页
 */
public class TestCustomer {
	private DemoCustomerService service = new DemoCustomerService();

	@Test
	public void addCustomer() {
		for (int i = 0; i < 100; i++) {
			DemoCustomerBean bean = new DemoCustomerBean();
			bean.setCid(GetUUIDRandomUtils.getUUIDRandomNum());
			bean.setGender("女");
			bean.setBirthday("2014-11-10");
			bean.setCellphone(i + "");
			bean.setCname("heli" + i);
			bean.setDescription("descrip" + i);
			service.add(bean);
		}
	}
}
