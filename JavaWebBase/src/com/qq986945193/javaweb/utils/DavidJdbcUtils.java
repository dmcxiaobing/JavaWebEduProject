package com.qq986945193.javaweb.utils;
/**
 * @Author ：程序员小冰
 * @GitHub: https://github.com/QQ986945193
 */
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 带有事务，以及连接池管理释放的工具类
 */
public class DavidJdbcUtils {
	// 配置文件的默认配置！要求你必须给出c3p0-config.xml！！！
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	// 它是事务专用连接！
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	/**
	 * 使用连接池返回一个连接对象
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();
		// 当con不等于null，说明已经调用过beginTransaction()，表示开启了事务！
		if (con != null)
			return con;
		return dataSource.getConnection();
	}

	/**
	 * 返回连接池对象！
	 * 
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 开启事务 1. 获取一个Connection，设置它的setAutoComnmit(false) 2.
	 * 还要保证dao中使用的连接是我们刚刚创建的！ -------------- 1. 创建一个Connection，设置为手动提交 2.
	 * 把这个Connection给dao用！ 3. 还要让commitTransaction或rollbackTransaction可以获取到！
	 * 
	 * @throws SQLException
	 */
	public static void beginTransaction() throws SQLException {
		Connection con = tl.get();
		if (con != null)
			throw new SQLException("已经开启了事务，就不要重复开启了！");
		/*
		 * 1. 给con赋值！ 2. 给con设置为手动提交！
		 */
		con = getConnection();// 给con赋值，表示事务已经开始了
		con.setAutoCommit(false);

		tl.set(con);// 把当前线程的连接保存起来！
	}

	/**
	 * 提交事务 1. 获取beginTransaction提供的Connection，然后调用commit方法
	 * 
	 * @throws SQLException
	 */
	public static void commitTransaction() throws SQLException {
		Connection con = tl.get();// 获取当前线程的专用连接
		if (con == null)
			throw new SQLException("还没有开启事务，不能提交！");
		/*
		 * 1. 直接使用con.commit()
		 */
		con.commit();
		con.close();
		// 把它设置为null，表示事务已经结束了！下次再去调用getConnection()返回的就不是con了
		tl.remove();// 从tl中移除连接
	}

	/**
	 * 提交事务 1. 获取beginTransaction提供的Connection，然后调用rollback方法
	 * 
	 * @throws SQLException
	 */
	public static void rollbackTransaction() throws SQLException {
		Connection con = tl.get();
		if (con == null)
			throw new SQLException("还没有开启事务，不能回滚！");
		/*
		 * 1. 直接使用con.rollback()
		 */
		con.rollback();
		con.close();
		tl.remove();
	}

	/**
	 * 释放连接
	 * 
	 * @param connection
	 * @throws SQLException
	 */
	public static void releaseConnection(Connection connection) throws SQLException {
		Connection con = tl.get();
		/*
		 * 判断它是不是事务专用，如果是，就不关闭！ 如果不是事务专用，那么就要关闭！
		 */
		// 如果con == null，说明现在没有事务，那么connection一定不是事务专用的！
		if (con == null)
			connection.close();
		// 如果con != null，说明有事务，那么需要判断参数连接是否与con相等，若不等，说明参数连接不是事务专用连接
		if (con != connection)
			connection.close();
	}
}
