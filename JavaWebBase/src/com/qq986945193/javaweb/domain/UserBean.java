package com.qq986945193.javaweb.domain;

public class UserBean {
	private String username;
	private String password;
	private String verifycode;

	public UserBean(String username, String password, String verifyCode) {
		super();
		this.username = username;
		this.password = password;
		this.verifycode = verifyCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public UserBean() {
		super();
	}

	@Override
	public String toString() {
		return "UserBean [username=" + username + ", password=" + password + ", verifyCode=" + verifycode + "]";
	}

}
