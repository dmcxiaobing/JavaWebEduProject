package com.qq986945193.javaweb.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 省的一个javabean，这里演示xstream
 */
public class Province {
	private String name;// 省名
	private List<City> citys = new ArrayList<City>();
	/**
	 * 添加市区
	 */
	public void addCity(City c){
		citys.add(c);
	}
	@Override
	public String toString() {
		return "Province [name=" + name + ", lists=" + citys + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public List<City> getCitys() {
		return citys;
	}
	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
	public Province() {
		super();
	}

	public Province(String name, List<City> citys) {
		super();
		this.name = name;
		this.citys = citys;
	}
	

}
