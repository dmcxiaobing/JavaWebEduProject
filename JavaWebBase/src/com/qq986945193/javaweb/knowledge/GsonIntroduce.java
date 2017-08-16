package com.qq986945193.javaweb.knowledge;

import java.io.Serializable;
/**
 * david 
 * http://weibo.com/mcxiaobing
 */
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
	
	/**
	 * 测试gson解析数据
	 */
	@Test
	public void TestGson(){
		String json = "{'result':false,'message':'密码错误'}";
		Gson gson = new Gson();
		Entity entity = gson.fromJson(json,Entity.class );
		System.out.println(entity.result);
		System.out.println(entity.message);
	}
	@Test
	public void TestGson2(){
		String json = "[{'childList':[{'name':'David①','pic_id':0,'state':'open'},{'name':'David②','pic_id':0,'state':'close'},{'name':'David③','pic_id':0,'state':'close'},{'name':'David④','pic_id':0,'state':'close'},{'name':'David⑤','pic_id':0,'state':'open'},{'name':'David⑥','pic_id':0,'state':'close'},{'name':'David⑦','pic_id':0,'state':'close'},{'name':'David⑧','pic_id':0,'state':'close'}],'name':'客厅'},{'childList':[{'name':'David①','pic_id':0,'state':'close'},{'name':'David②','pic_id':0,'state':'close'},{'name':'David③','pic_id':0,'state':'close'},{'name':'David④','pic_id':0,'state':'close'},{'name':'David⑤','pic_id':0,'state':'close'},{'name':'David⑥','pic_id':0,'state':'close'},{'name':'David⑦','pic_id':0,'state':'close'},{'name':'David⑧','pic_id':0,'state':'close'}],'name':'主Java'},{'childList':[{'name':'David①','pic_id':0,'state':'close'},{'name':'David②','pic_id':0,'state':'close'},{'name':'David③','pic_id':0,'state':'close'},{'name':'David④','pic_id':0,'state':'close'},{'name':'David⑤','pic_id':0,'state':'close'},{'name':'David⑥','pic_id':0,'state':'close'},{'name':'David⑦','pic_id':0,'state':'close'},{'name':'David⑧','pic_id':0,'state':'close'}],'name':'Java一'},{'childList':[{'name':'David①','pic_id':0,'state':'close'},{'name':'David②','pic_id':0,'state':'close'},{'name':'David③','pic_id':0,'state':'close'},{'name':'David④','pic_id':0,'state':'close'},{'name':'David⑤','pic_id':0,'state':'close'},{'name':'David⑥','pic_id':0,'state':'close'},{'name':'David⑦','pic_id':0,'state':'close'},{'name':'David⑧','pic_id':0,'state':'close'}],'name':'Java二'}]";
		System.out.println(json);
		Gson gson = new Gson();
		List<GroupInfoModel>listGroup = gson.fromJson(json,
                new TypeToken<List<GroupInfoModel>>() {
                }.getType());
		System.out.println(listGroup.get(0).getChildList().get(0).getName());
	
	}
	
	
	class Entity{
		public String result;
		public String message;
	}
	
	
	
}

class GroupInfoModel implements Serializable{

    private String name;
    private List<Child> childList;//该分组写子列表

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public GroupInfoModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupInfoModel(String name) {
        this.name = name;
    }
}


class Child{
	  /**
   * childList : [{"name":"David①","pic_id":0,"state":"open"},{"name":"David②","pic_id":0,"state":"close"},{"name":"David③","pic_id":0,"state":"close"},{"name":"David④","pic_id":0,"state":"close"},{"name":"David⑤","pic_id":0,"state":"open"},{"name":"David⑥","pic_id":0,"state":"close"},{"name":"David⑦","pic_id":0,"state":"close"},{"name":"David⑧","pic_id":0,"state":"close"}]
   * name : 客厅
   */

  private String name;
  private List<ChildListBean> childList;

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public List<ChildListBean> getChildList() {
      return childList;
  }

  public void setChildList(List<ChildListBean> childList) {
      this.childList = childList;
  }

  public static class ChildListBean {
      /**
       * name : David①
       * pic_id : 0
       * state : open
       */

      private String name;
      private int pic_id;
      private String state;

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }

      public int getPic_id() {
          return pic_id;
      }

      public void setPic_id(int pic_id) {
          this.pic_id = pic_id;
      }

      public String getState() {
          return state;
      }

      public void setState(String state) {
          this.state = state;
      }
  }
}
