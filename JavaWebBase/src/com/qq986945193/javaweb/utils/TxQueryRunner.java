package com.qq986945193.javaweb.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

/**
 * 这个类中的方法，自己来处理连接的问题
 * 无需外界传递！　
 * 怎么处理的呢？
 *   通过DavidJdbcUtils.getConnection()得到连接！有可能是事务连接，也可能是普通的连接！
 *   DavidJdbcUtils.releaseConnection()完成对连接的释放！如果是普通连接，关闭之！
 *
 */
public class TxQueryRunner extends QueryRunner {
	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		/*
		 * 1. 得到连接
		 * 2. 执行父类方法，传递连接对象
		 * 3. 释放连接
		 * 4. 返回值
		 */
		Connection con = DavidJdbcUtils.getConnection();
		int[] result = super.batch(con, sql, params);
		DavidJdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, Object param, ResultSetHandler<T> rsh)
			throws SQLException {
		Connection con = DavidJdbcUtils.getConnection();
		T result = super.query(con, sql, param, rsh);
		DavidJdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh)
			throws SQLException {
		Connection con = DavidJdbcUtils.getConnection();
		T result = super.query(con, sql, params, rsh);
		DavidJdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
			throws SQLException {
		Connection con = DavidJdbcUtils.getConnection();
		T result = super.query(con, sql, rsh, params);
		DavidJdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = DavidJdbcUtils.getConnection();
		T result = super.query(con, sql, rsh);
		DavidJdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql) throws SQLException {
		Connection con = DavidJdbcUtils.getConnection();
		int result = super.update(con, sql);
		DavidJdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object param) throws SQLException {
		Connection con = DavidJdbcUtils.getConnection();
		int result = super.update(con, sql, param);
		DavidJdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		Connection con = DavidJdbcUtils.getConnection();
		int result = super.update(con, sql, params);
		DavidJdbcUtils.releaseConnection(con);
		return result;
	}
}
