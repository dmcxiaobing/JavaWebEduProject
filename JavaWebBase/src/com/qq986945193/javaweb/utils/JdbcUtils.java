package com.qq986945193.javaweb.utils;
/**
 * @Author ：程序员小冰
 * @GitHub: https://github.com/QQ986945193
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 最简单的一个jdbc的封装工具类
 */
public class JdbcUtils {
	private static Properties properties;

	/**
	 * 只在jdbcutils类加载时执行一次
	 */
	static {
		try {
			// 给properties进行初始化，即加载dbconfig.properties文件
			InputStream iStream = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			properties = new Properties();
			properties.load(iStream);
			// 加载驱动类
			Class.forName(properties.getProperty("driverClassName"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 获取connection连接
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
				properties.getProperty("password"));
	}
}
