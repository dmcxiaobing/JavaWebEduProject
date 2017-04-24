package com.qq986945193.javaweb.dao;

import com.qq986945193.javaweb.domain.User;

/**
 * 这里是一个dao，一个持久层，也就是所谓的操作数据库
 */
public class MvcClickDao {
	/**
	 * 将数据库或者xml等里面的数据查找出来，封装到javabean中。
	 * 
	 */
	public User findUser() {
		return new User("admin", "password");
	}
}
