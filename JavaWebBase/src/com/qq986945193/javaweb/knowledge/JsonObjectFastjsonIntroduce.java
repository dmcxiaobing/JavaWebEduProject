package com.qq986945193.javaweb.knowledge;
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.math.RandomUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qq986945193.javaweb.utils.MD5Utils;

import net.sf.json.JSONArray;

/**
 * jsonobject与fastjson的简单使用 author:David
 */
public class JsonObjectFastjsonIntroduce {
	public static void main(String[] args) {
//		testFastjson();
//		testFastJson2();
//		testJsonObject1();
//		testJsonObject2();
		testJsonObject3();
	

	}
	/**
	 * 返回带有数组的json
	 * 
	 *
	 * 
				{
			    "result": true,
			    "tokenpwd": "7E16B5A53CD29BE5B3E65BFF08830CE5",
			    "tokenusername": "DCC012250BE78383866E889A2231C978",
			    "objs": [
			        {
			            "fieldname": "fieldnamevalue",
			            "typeid": "typeid"
			        },
			        {
			            "fieldname": "fieldnamevalue",
			            "typeid": "typeid"
				        }
				    ]
				}
	 */
	private static void testJsonObject3() {
		JSONObject o = new JSONObject();
		o.put("result", true);
		o.put("tokenusername", MD5Utils.strToMD5((UUID.nameUUIDFromBytes("david".getBytes())+new Date().toLocaleString()+RandomUtils.nextInt(2))));
		o.put("tokenpwd", MD5Utils.strToMD5((UUID.nameUUIDFromBytes("david".getBytes())+new Date().toLocaleString()+RandomUtils.nextInt(2))));
		
		JSONArray array = new JSONArray();
		
		Map<String, String> map = new HashMap<>();
		map.put("typeid", "typeid");
		map.put("fieldname", "fieldnamevalue");
		array.add(map);
		array.add(map);
		o.put("objs", array);
		System.out.println(o.toString());
	}
	/**
	 * 返回json字符串
	 */
	private static void testJsonObject2() {
		JSONObject o = new JSONObject();
		o.put("result", false);
		o.put("message", "密码错误");
		System.out.println(o.toString());
	}
	/**
	 * 测试jsonObject
	 */
	private static void testJsonObject1() {
		JSONObject o = new JSONObject();
		o.put("message", "登陆失败");
		System.out.println(o.toString());
	}

	/**
	 * 测试fastjson
	 */
	private static void testFastJson2() {

		JSONObject result = new JSONObject();
		JSONObject output = new JSONObject();
		JSONObject data = new JSONObject();
		
		
		result.put("msg", "登录成功");
		result.put("status", "200");
		data.put("page", "我的首页");
		data.put("uid", "id");
		
		data.put("logintag", "1");
		output.put("data", data);
		output.put("result", result);

		System.out.println("test2:"+output.toJSONString());
	}

	/**
	 * fastjson简单使用 返回json字符串：{"result":"success"}
	 */
	private static void testFastjson() {
		// 将结果序列化成json
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		String result = JSON.toJSONString(map);
		System.out.println(result);
	}
}
