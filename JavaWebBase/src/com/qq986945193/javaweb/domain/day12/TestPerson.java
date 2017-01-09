package com.qq986945193.javaweb.domain.day12;

/**
 * BeanUtils的使用
 */
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.qq986945193.javaweb.utils.CommonUtils;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
public class TestPerson {
	/**
	 * beanUtils的简单应用
	 */
	@Test
	public void testPerson() throws Exception {
		// 获取类
		String className = "com.qq986945193.javaweb.domain.day12.Person";
		// 根据类 生成Class对象
		Class class1 = Class.forName(className);
		Object bean = class1.newInstance();
		/**
		 * 利用beanUtils进行设置属性
		 */
		BeanUtils.setProperty(bean, "name", "程序员小冰");
		BeanUtils.setProperty(bean, "age", "999999");
		BeanUtils.setProperty(bean, "gender", "男");

		System.out.println(bean);

		String ageString = BeanUtils.getProperty(bean, "age");
		System.out.println("age == " + ageString);
	}

	/**
	 * 将map中的数据直接封装到一个javabean中
	 */
	@Test
	public void testUser() throws IllegalAccessException,
			InvocationTargetException {
		// 新建一个map并填充数据
		Map<String, String> map = new HashMap<>();
		map.put("username", "root");
		map.put("password", "root123");
		User user = new User();
		// 使用beanUtils进行填充
		BeanUtils.populate(user, map);
		System.out.println(user);
	}
	/**
	 * 利用自己简单封装的Beanutils将map数据存到javabean中
	 */
	@Test
	public void testUserBeanUtis() {
		Map<String, String> map = new HashMap<>();
		map.put("username", "admin");
		map.put("password", "123456");
		User user = CommonUtils.toBean(map, User.class);
		System.out.println(user);
 	}

}
