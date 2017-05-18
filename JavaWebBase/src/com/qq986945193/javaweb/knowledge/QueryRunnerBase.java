package com.qq986945193.javaweb.knowledge;
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.qq986945193.javaweb.utils.JdbcUtils;

/**
 * 模仿DButils中的QueryRunner
 * 
 * @param <T>
 */
public class QueryRunnerBase<T> {
	/**
	 * 连接池对象
	 */
	private DataSource dataSource;

	public QueryRunnerBase(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	/**
	 * 这里做数据库的insert，update,delete 增加，更改以及删除的功能
	 */
	public void update(String sql, Object... params) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// 得到连接池对象
			connection = JdbcUtils.getC3P0Connection();
			// 使用sql语句获取到PreparedStatement
			preparedStatement = connection.prepareStatement(sql);
			// 设置参数
			initParams(params, preparedStatement);
			// 执行增，改，删的操作
			preparedStatement.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	/**
	 * 给sql中参数赋值
	 * 
	 * @param preparedStatement
	 * @param params
	 * @throws SQLException
	 */
	private void initParams(Object[] params, PreparedStatement preparedStatement) throws SQLException {
		for (int i = 0; i < params.length; i++) {
			preparedStatement.setObject(i + 1, params[i]);
		}
	}

	/**
	 * 查询数据库的操作
	 */
	public T query(String sql, RsHandler<T> resHandler, Object... params) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 获取连接池对象
			connection = JdbcUtils.getC3P0Connection();
			// 得到PreparedStatement对象
			preparedStatement = connection.prepareStatement(sql);
			// 初始化参数
			initParams(params, preparedStatement);
			// 得到resultSet对象
			resultSet = preparedStatement.executeQuery();
			return resHandler.handler(resultSet);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	interface RsHandler<T> {
		public T handler(ResultSet resultSet) throws SQLException;
	}

}
