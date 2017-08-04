package com.qq986945193.javaweb.knowledge;

/**
 * david 
 * http://weibo.com/mcxiaobing
 */
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.omg.CORBA.PRIVATE_MEMBER;

import com.google.gson.Gson;
import com.qq986945193.javaweb.domain.UpdateAppBean;
import com.qq986945193.javaweb.domain.UpdateAppNoListBean;
import com.qq986945193.javaweb.domain.User;

/**
 * 利用google的gson操作json的一些简单介绍。
 */
public class GsonIntroduce {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		// TODO 自动生成的方法存根
		// 生成json
		List<User> arrayList = new ArrayList<User>();
		User stu1 = new User("username", "男");
		User stu2 = new User("李四", "男");
		User stu3 = new User("王二", "女");
		
		arrayList.add(stu1);
		arrayList.add(stu2);
		arrayList.add(stu3);
		
		Gson gson = new Gson();
		// 对单个实例操作
		String jsonBean = gson.toJson(stu1);
		System.out.println("对单个实例操作:"+jsonBean);


		// 将对象的集合转换成json字符串
		String json = gson.toJson(arrayList);
		
		System.out.println("对象的集合转换:"+json);
		/**
		 * 返回带有集合的数据 并有字符串
		 */
		UpdateAppBean bUpdateAppBean = new UpdateAppBean();
		List<UpdateAppBean.MsgBean> listsMsgBeans = new ArrayList<UpdateAppBean.MsgBean>();
		UpdateAppBean.MsgBean msgBean = new UpdateAppBean.MsgBean();
		BeanUtils.setProperty(bUpdateAppBean, "status", "success");
		BeanUtils.setProperty(msgBean, "description", "这是一个新版本的描述信息");
		BeanUtils.setProperty(msgBean, "downloadApkUrl", "ir;");
		BeanUtils.setProperty(msgBean, "versionCode", "2");
		// 添加到集合中
		listsMsgBeans.add(msgBean);
		System.err.println(listsMsgBeans.size());
		BeanUtils.setProperty(bUpdateAppBean, "msg", listsMsgBeans);
		
		
		String jsonValue = gson.toJson(bUpdateAppBean);
		System.out.println("返回带有集合的数据 并有字符串:"+jsonValue);
		/**
		 * 返回没有集合的数据 只有字符串
		 */
		UpdateAppNoListBean mUpdateAppBean = new UpdateAppNoListBean();
		UpdateAppNoListBean.MsgBean mMsgBean = new UpdateAppNoListBean.MsgBean();
		BeanUtils.setProperty(mUpdateAppBean, "status", "success");
		BeanUtils.setProperty(mMsgBean, "description", "这是一个新版本的描述信息");
		BeanUtils.setProperty(mMsgBean, "downloadApkUrl", "ir;");
		BeanUtils.setProperty(mMsgBean, "versionCode", "2");
		BeanUtils.setProperty(mUpdateAppBean, "msg", mMsgBean);
		String jsonStrValue = gson.toJson(mUpdateAppBean);
		System.out.println("返回没有集合的数据 只有字符串:"+jsonStrValue);
	}
}
