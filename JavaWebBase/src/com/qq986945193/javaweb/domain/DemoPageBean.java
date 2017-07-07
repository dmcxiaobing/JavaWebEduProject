package com.qq986945193.javaweb.domain;

import java.util.List;

/**
 * 分页查询客户的，一个页码之类的javabean
 */
public class DemoPageBean<T> {
	private int pc;// pageCode,当前页码
	private int tr;// totalRecord,总记录数
	private int ps;// pageSize，每页记录数
	private int tp;// totalPage,总页数
	private List<T> datas;// 当前页记录
	private String url;// 用来保存条件

	/**
	 * 返回总页数
	 */
	public int getTp() {
		//总记录数 除以 每页记录数
		int tp = tr / ps;
		//如果正好能够整除，则总页数为总页数tp,否则为tp+1
		return tr % ps == 0 ? tp : tp + 1;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getTr() {
		return tr;
	}

	public void setTr(int tr) {
		this.tr = tr;
	}

	public int getPs() {
		return ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}


	public void setTp(int tp) {
		this.tp = tp;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
