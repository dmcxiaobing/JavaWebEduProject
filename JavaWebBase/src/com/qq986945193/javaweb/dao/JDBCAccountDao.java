package com.qq986945193.javaweb.dao;
/**
 * http://weibo.com/mcxiaobing
 */
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 转账更新的操作
 */
public class JDBCAccountDao {

	public void updateBalance(String fromUser, String toUser, Double banlance, PreparedStatement preparedStatement) throws SQLException {
		/**
		 * 给出sql模板
		 */
		String sql = "update tb_account set banlance = balance+? where username = ?";
		preparedStatement.setDouble(2, banlance);
		preparedStatement.setString(1, toUser);
		preparedStatement.executeUpdate();
		
	}

}
