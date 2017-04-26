package com.qq986945193.javaweb.service;

import com.qq986945193.javaweb.dao.UserDao;
import com.qq986945193.javaweb.domain.User;
import com.qq986945193.javaweb.domain.UserBean;
import com.qq986945193.javaweb.exception.UserException;

/**
 * 这是注册的service
 */
public class UserService {
	//service依赖dao持久层
	private UserDao userDao = new UserDao();
	/**
	 * 注册的功能
	 * @param user
	 * @throws UserException
	 */
	public void regist(UserBean userbean) throws UserException{
		/**
		 * 1,首先使用用户名去查询，是否存在，如果返回null则添加数据库
		 * 2,如果返回的结果不是null，则证明已经存在了用户名，抛出异常
		 */
		UserBean userBean = userDao.findByUsername(userbean.getUsername());
		if (userBean == null) {
			//添加进去
			userDao.addByUserName(userbean);
		}else {
			throw new UserException("用户名"+userbean.getUsername()+"已经被注册了");
		}
		
	}
	/**
	 * 登陆的功能
	 * @param userBean 用户输入的用户名和密码
	 */
	public UserBean login(UserBean formUserBean)throws UserException {
		/**
		 * 1,使用formUserbean进行查询，得到user,若果不存在，则返回用户名不存在。
		 */
		
		UserBean userBean = userDao.findByUsername(formUserBean.getUsername());
		if (userBean == null) {
			throw new UserException("用户名不存在");
		}
		/**
		 * 2,比较用户输入的用户名和密码和存在的是否一致
		 */
		if (!formUserBean.getPassword().equals(userBean.getPassword())) {
			throw new UserException("密码错误!");
		}
		/**
		 * 返回数据库存在的userbean，因为，这个可能有其他属性。而用户输入的只有用户名和密码属性
		 */
		return userBean;
	
	}
	
}
