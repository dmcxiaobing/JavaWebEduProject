package com.qq986945193.javaweb.knowledge;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * jsonobject与fastjson的简单使用 author:David
 */
public class JsonObjectFastjsonIntroduce {
	public static void main(String[] args) {
		testFastjson();
		testFastJson2();

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
