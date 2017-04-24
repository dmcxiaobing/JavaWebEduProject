package com.qq986945193.javaweb.service;

import com.qq986945193.javaweb.dao.MvcClickDao;
import com.qq986945193.javaweb.domain.User;

/**
 * 一个业务层的类，查找用户
 */
public class MvcClickService {
	MvcClickDao dao = new MvcClickDao();

	/**
	 * 业务层service依赖dao层，所以这里查找利用 dao层进行
	 */
	public User findUser() {
		return dao.findUser();
	}
}
