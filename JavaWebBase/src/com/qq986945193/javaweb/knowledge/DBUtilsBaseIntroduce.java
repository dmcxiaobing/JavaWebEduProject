package com.qq986945193.javaweb.knowledge;
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qq986945193.javaweb.domain.User;
import com.qq986945193.javaweb.knowledge.QueryRunnerBase.RsHandler;
import com.qq986945193.javaweb.utils.JdbcUtils;

/**
 * 
 * 模仿DButils中的QueryRunner
 */
public class DBUtilsBaseIntroduce {

	/**
	 * 测试我们自己写的queryRunner,进行添加数据和查询拘束
	 */
	public void funDbutils() {
		// User user = load(22);
		// System.out.println(user);
		User user = new User("zhangsan", "12345");
		insertUser(user);
	}

	/**
	 * 添加插入数据
	 */
	private void insertUser(User user) {
		// 创建对象时给出连接池对象
		QueryRunnerBase<User> queryRunnerBase = new QueryRunnerBase<User>(JdbcUtils.getDataSource());
		// 创建sql模板
		String sql = "insert into tb_user values(?,?)";
		// 设置参数
		Object[] params = { user.getusername(), user.getpassword() };
		// 调用增，删，改的方法
		queryRunnerBase.update(sql, params);
	}

	/**
	 * 根据uid查询用户信息
	 */
	public User load(int uid) {
		QueryRunnerBase<User> queryRunner = new QueryRunnerBase<User>(JdbcUtils.getDataSource());
		String sql = "select * from tb_user where uid = ?";
		Object[] params = { uid };
		RsHandler<User> rsHandler = new RsHandler<User>() {

			@Override
			public User handler(ResultSet resultSet) throws SQLException {
				// TODO Auto-generated method stub
				if (resultSet.next()) {
					User user = new User();
					// 根据表名字段获取用户信息
					user.setusername(resultSet.getString("username"));
					user.setpassword(resultSet.getString("password"));
					return user;
				} else {
					return null;
				}
			}
		};
		return queryRunner.query(sql, rsHandler, params);

	}
}
