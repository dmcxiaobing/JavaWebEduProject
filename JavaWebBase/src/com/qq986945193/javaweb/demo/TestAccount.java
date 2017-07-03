package com.qq986945193.javaweb.demo;

import java.sql.SQLException;

import org.junit.Test;

import com.qq986945193.javaweb.dao.TestAccountDao;
import com.qq986945193.javaweb.utils.DavidJdbcUtils;
import com.qq986945193.javaweb.utils.JdbcUtils;

/**
 * 转账的一个小 demo
 */
public class TestAccount {
	private TestAccountDao dao = new TestAccountDao();

	/**
	 * 转账的一个小功能演示 这里直接省略不写service业务层了。直接就表示是在业务层操作的
	 */
	@Test
	public void updateAccountService() {
		try {
			// 业务层中开启事务
			DavidJdbcUtils.beginTransaction();
			// zs减少100
			dao.update("zs", -100);
			// ls加上100
			dao.update("li", 100);
			// 开启事务
			DavidJdbcUtils.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			// 若是转账发生异常，则回滚事务
			try {
				DavidJdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
