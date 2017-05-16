package com.qq986945193.javaweb.knowledge;
/**
 * @Author ：程序员小冰
 * @GitHub: https://github.com/QQ986945193
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.Statement;
import com.qq986945193.javaweb.utils.JdbcUtils;

/**
 * 演示一下sql注入攻击的代码 
 * 所以我们操作应该使用preparedstatement,和sql模板参数用？代替
 */
public class JDBCSqlIntroduce {
	@Test
	public void funTest() throws ClassNotFoundException, IOException, SQLException{
//		String username = "zhangsan";
//		String password = "1234";
//		System.out.println(login(username, password));
		/**
		 * 下面使用sql攻击
		 */
		String username = "a' or 'a'='a";
		String password = "a' or 'a'='a";
		System.out.println(username);
		System.out.println(password);
		//select * from tb_user where username = 'a' or 'a'='a' and password = 'a' or 'a'='a'
		//也是返回的true
		System.out.println(loginPreparedStatment(username, password));
	
	}
	
	/**
	 * 登陆，使用username和password去查询数据 若查询出结果集，则返回true，若查询不到则说明用户名或密码错误，返回false
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public boolean login(String username, String password) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = JdbcUtils.getConnection();
		/**
		 * 这里提前说明，使用statement和直接写sql代码，会有sql注入的攻击
		 */
		java.sql.Statement statement = connection.createStatement();
		String sqlString = "select * from tb_user where username = '" + username + "' and password = '" + password + "'";
		System.out.println(sqlString);
		ResultSet resultSet = statement.executeQuery(sqlString);
		return resultSet.next();
	}
	/**
	 * 登陆，使用username和password去查询数据 若查询出结果集，则返回true，若查询不到则说明用户名或密码错误，返回false
	 * 这里解决了sql注入问题
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public boolean loginPreparedStatment(String username, String password) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = JdbcUtils.getConnection();
		/**
		 * 这里提前说明，使用statement和直接写sql代码，会有sql注入的攻击
		 */
		String sqlString = "select * from tb_user where username = ? and password = ?";
		System.out.println(sqlString);
		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
		/**
		 * 这里设置参数是根据表记录进行设置的。表的列位置
		 */
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery(sqlString);
		return resultSet.next();
	}
	
}
