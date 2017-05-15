package com.qq986945193.javaweb.knowledge;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import com.qq986945193.javaweb.constans.Api;
import com.qq986945193.javaweb.utils.DbcpConnectionWrapper;

/**
 * dbcp连接池的介绍
 */
public class DbcpConectionIntroduce {
	@Test
	private void funDbcp() throws SQLException {
		/**
		 * 创建连接池对象，配置四大参数。 配置池参数，得到连接对象
		 */
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(Api.JDBC_CLASS_NAME_FOR_MYSQL);
		dataSource.setUrl(Api.JDBC_URL_FOR_MYSQL);
		dataSource.setUsername(Api.JDBC_USERNAME_FOR_MYSQL);
		dataSource.setPassword(Api.JDBC_PASSWORD_FOR_MYSQL);
		/**
		 * 设置连接池参数
		 */
		dataSource.setMaxActive(20);
		dataSource.setMinIdle(3);
		dataSource.setMaxWait(1000);
		//得到连接对象
		Connection connection = dataSource.getConnection();
		/**
		 * 连接池内部使用四大参数创建了连接对象！即mysql驱动提供的Connection
		 * 连接池使用mysql的连接对象进行了装饰，只对close()方法进行了增强！
		 * 装饰之后的Connection的close()方法，用来把当前连接归还给池！
		 */
		Connection connection2 = new DbcpConnectionWrapper(connection);
		//将连接池还给他
		connection2.close();
	
	}
}
