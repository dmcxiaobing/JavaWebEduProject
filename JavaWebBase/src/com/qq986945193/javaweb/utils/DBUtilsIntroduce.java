package com.qq986945193.javaweb.utils;

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

import com.qq986945193.javaweb.domain.User;

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
	public void funQuery() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from tb_user where uid = ?";
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
	
		/**
		 * 使用BeanListHandler返回一个对象的集合  多行处理器
		 */
		List<User> userLists = queryRunner.query(sql, new BeanListHandler<User>(User.class), object);
		/**
		 * 使用MapHandler 把一行转换成一个Map对象  单行处理器
		 */
		Map map = queryRunner.query(sql,new MapHandler(),object);
		/**
		 * Map
		 */
	}

}
