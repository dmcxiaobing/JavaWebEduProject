package com.qq986945193.javaweb.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qq986945193.javaweb.domain.DemoBook;
import com.qq986945193.javaweb.utils.TxQueryRunner;

/**
 * 测试一个缓存html页面的业务层
 *  这里为了方便，不写持久层了，直接在业务层进行查询了、
 */
public class DemoBookService {
	private QueryRunner queryRunner = new TxQueryRunner();
	/**
	 * 查询所有的图书
	 */
	public List<DemoBook> findAll() throws SQLException {
		String sql = "select * from book";
		return queryRunner.query(sql, new BeanListHandler<DemoBook>(DemoBook.class));
	}
	/**
	 * 根据cid查询图书
	 */
	public List<DemoBook> findByCid(String cid) throws SQLException {
		String sql = "select * from book where cid = ?";
		Object[] params = {cid};
		
		return queryRunner.query(sql, new BeanListHandler<DemoBook>(DemoBook.class),params);
	}

}
