package com.qq986945193.javaweb.domain;

import java.util.Date;

/**
 * 客户的一个实体类
 */
public class DemoCustomerBean {
	private String cid;
	private String cname;
	private String birthday;
	private String gender;
	private String cellphone;
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

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	@Override
	public String toString() {
		return "DemoCustomerBean [cid=" + cid + ", cname=" + cname + ", birthday=" + birthday + ", gender=" + gender
				+ ", cellphone=" + cellphone + ", email=" + email + ", description=" + description + "]";
	}
	
}
