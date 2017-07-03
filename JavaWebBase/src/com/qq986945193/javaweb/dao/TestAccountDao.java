package com.qq986945193.javaweb.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.qq986945193.javaweb.utils.TxQueryRunner;

/**
 * 测试转账的一个小demo。
 * 这里是业务层
 */
public class TestAccountDao {

	/**
	 * 更新数据库的金额
	 * @param username  用户名
	 * @param account 发生交易的金额数
	 */
	public void update(String username, int account) throws SQLException {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "update account set balance = balance+? where username = ?";
		Object[] params = {account,username};
		queryRunner.update(sql,params);
	}

}
