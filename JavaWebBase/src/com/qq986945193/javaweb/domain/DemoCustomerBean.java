package com.qq986945193.javaweb.domain;

import java.util.Date;

/**
 * 客户的一个实体类
 */
public class DemoCustomerBean {
	private String cid;
	private String cname;
	private Date cbirthday;
	private String gender;
	private String phone;
	private String email;
	private String description;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Date getCbirthday() {
		return cbirthday;
	}
	public void setCbirthday(Date cbirthday) {
		this.cbirthday = cbirthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
