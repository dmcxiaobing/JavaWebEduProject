package com.qq986945193.javaweb.domain;

import java.util.List;

/**
 * 省的javabean
 */
public class AjaxJsonProvince {
	private int pid;
	private String name;
	private List<AjaxJsonCity> cityList;//一方关联多方
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<AjaxJsonCity> getCityList() {
		return cityList;
	}
	public void setCityList(List<AjaxJsonCity> cityList) {
		this.cityList = cityList;
	}
	
}
