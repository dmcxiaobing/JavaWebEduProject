package com.qq986945193.javaweb.knowledge;
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.qq986945193.javaweb.domain.User;
import com.qq986945193.javaweb.utils.JdbcUtils;

/*
 * dbutils的使用简单介绍
 */
public class DBUtilsIntroduce {
	/**
	 * 增删改的使用
	 * 
	 * @throws SQLException
	 */
	public void fun() throws SQLException {
		/**
		 * 新建一个QuerRunner对象，传递一个线程池对象
		 */
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
		// 创建sql模板
		String sql = "insert into tb_user values(?,?)";
		// 传递参数
		Object objects[] = { "zhangsan", 22 };
		queryRunner.update(sql);
	}

	/**
	 * 查询的功能 返回ResultSet和JavaBean对象 单行处理
	 * @throws SQLException 
	 */
	@Test
	public void funQuery() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from exam_user where uid = ?";
		//给出参数
		Object object[] = {1};
		//返回一个ResultSet
		ResultSetHandler<User> resultSetHandler = new ResultSetHandler<User>() {

			@Override
			public User handle(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
		};
//		queryRunner.query(sql, resultSetHandler,object);
		//也可以直接调用query方法，传递BeanHandler(它是ResultSetHandler的实现类)
//		User user = queryRunner.query(sql, new BeanHandler<User>(User.class), object);
	
		sql = "select * from tb_user";
		/**
		 * 使用BeanListHandler返回一个对象的集合  多行处理器
		 */
		List<User> userLists = queryRunner.query(sql, new BeanListHandler<User>(User.class), object);
		sql = "select * from tb_user where uid = ?";
		/**
		 * 使用MapHandler 把一行转换成一个Map对象  单行处理器
		 */
		Map map = queryRunner.query(sql,new MapHandler(),object);
		/**
		 * MapListHandler 返回一个map集合。多行处理
		 */
		sql = "select * from tb_user";
		List<Map<String, Object>> mapLists = queryRunner.query(sql, new MapListHandler());
		/**
		 * ScalarHandler,单行使用最后合适。
		 */
		sql = "select * from tb_user where uid = ?";
		Number number = (Number) queryRunner.query(sql, new ScalarHandler());
		long c = number.longValue();
		System.out.println(c);
	}

}
