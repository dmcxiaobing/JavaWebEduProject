package com.qq986945193.javaweb.knowledge;
/*
 * 作者：david 程序员小冰
 */
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.qq986945193.javaweb.constans.Api;

/**
 * C3P0连接池的功能介绍
 */
public class C3p0ConnectionIntroduce {
	/**
	 * 代码中配置c3p0连接池
	 * 
	 * @throws PropertyVetoException
	 * @throws SQLException
	 */
	@Test
	public void funC3P0() throws PropertyVetoException, SQLException {
		/**
		 * 创建连接池对象，并设置四大参数和池配置
		 */
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(Api.JDBC_CLASS_NAME_FOR_MYSQL);
		dataSource.setJdbcUrl(Api.JDBC_URL_FOR_MYSQL);
		dataSource.setUser(Api.JDBC_USERNAME_FOR_MYSQL);
		dataSource.setPassword(Api.JDBC_PASSWORD_FOR_MYSQL);
		/**
		 * 配置连接池参数
		 */

		dataSource.setAcquireIncrement(5);
		dataSource.setInitialPoolSize(20);
		dataSource.setMinPoolSize(2);
		dataSource.setMaxPoolSize(50);

		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}

	/**
	 * 使用默认的配置文件默认配置c3p0
	 * 
	 * @throws SQLException
	 */
	@Test
	public void funDefaultC3p0() throws SQLException {
		/**
		 * 在创建连接池对象时，这个对象就会自动加载配置文件
		 */
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection connection = dataSource.getConnection();
		connection.close();
	}

	/**
	 * 根据命名信息，使用我们自定义的配置信息
	 */
	@Test
	public void funCustomC3p0() throws SQLException {
		/**
		 * 构造方法的参数指定命名配置元素的名称 <named-config name="oracle-config">
		 */
		ComboPooledDataSource dataSource = new ComboPooledDataSource("oracle-config");
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();

	}

}
