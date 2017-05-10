package com.qq986945193.javaweb.domain;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
/*
 * 这里随便写一个登陆成功的javabean
 */
public class LoginActionServletBean {
	/**
	 * { "result": { "resultCode": 1, "resultMsg": "success" } }
	 */
	private String resultMsg;
	private int resultCode;

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public LoginActionServletBean() {
		super();
	}

}
