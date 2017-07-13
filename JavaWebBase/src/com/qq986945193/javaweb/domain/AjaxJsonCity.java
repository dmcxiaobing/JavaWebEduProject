package com.qq986945193.javaweb.domain;
/**
 * city的javabean
 */
public class AjaxJsonCity {
	private int cid;
	private String name;
	private AjaxJsonProvince province;//多方关联一方
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AjaxJsonProvince getProvince() {
		return province;
	}
	public void setProvince(AjaxJsonProvince province) {
		this.province = province;
	}
	
	
}
