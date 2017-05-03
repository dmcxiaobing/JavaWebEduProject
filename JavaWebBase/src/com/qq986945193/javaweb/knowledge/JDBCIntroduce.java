package com.qq986945193.javaweb.knowledge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;

/**
 * jdbc的一些简单的功能介绍
 */
public class JDBCIntroduce {

	@Test
	public void fun1() throws ClassNotFoundException, SQLException {
		java.sql.Connection connection = getConnection();
		insert(connection);
	}

	private void insert(Connection connection) throws SQLException {
		if (connection != null) {
			// 不等于空，则说明连接成功 Statement是用来向数据库发送要执行的SQL语句的！
			Statement createStatement = connection.createStatement();
			String sqlString = "insert into user values ('lisis',22)";
			/**
			 * 执行sql语句 发送增删改语句
			 */
			createStatement.executeUpdate(sqlString);
			/**
			 * 发送查询的sql语句
			 */
			String sqlSelctString = "select * from user";
			// 得到查询结果，然后将查询结果的内容读取出来
			ResultSet executeQuery = createStatement.executeQuery(sqlSelctString);
			while (executeQuery.next()) {
				String username = executeQuery.getString("name");
				String password = executeQuery.getString("age");
				System.out.println(username + "," + password);
			}

			executeQuery.close();
			createStatement.close();
			connection.close();
		}

	}

	/**
	 * 加载驱动并进行获取连接 /** ClassNotFoundException找不到类 可能没导入驱动包
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 *             检查是否开启了mysql服务器以及用户名密码是否正确
	 */
	private java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
		/*
		 * jdbc四大配置参数： > driverClassName：com.mysql.j dbc.Driver >
		 * url：jdbc:mysql://localhost:3306/db3 > username：root > password：123
		 */
		/*
		 * 所有的java.sql.Driver实现类，都提供了static块，块内的代码就是把自己注册到 DriverManager中！
		 */
		/*
		 * jdbc4.0之后，每个驱动jar包中，在META-INF/services目录下提供了一个名为java.sql.Driver的文件。
		 * 文件的内容就是该接口的实现类名称！
		 */
		Class.forName("com.mysql.jdbc.Driver");
		// com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
		// DriverManager.registerDriver(driver);
		// 使用url、username、password，得到连接对象
		java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "1234");
		System.out.println(connection);
		return connection;
	}
}
