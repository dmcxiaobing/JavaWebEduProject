package com.qq986945193.javaweb.knowledge;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class JsonObjectFastjsonIntroduce {
	public static void main(String[] args) {
		testFastjson();

	}

	/**
	 * fastjson简单使用
	 */
	private static void testFastjson() {
		// 将结果序列化成json
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		String result = JSON.toJSONString(map);
		System.out.println(result);
	}
}
