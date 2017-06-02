package com.qq986945193.javaweb.domain;

import nu.xom.Element;

/**
 * XOM的使用javabean
 */
public class XomBean {
	private String firstName;
	private String lastName;

	public XomBean(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public XomBean() {
		super();
	}

	/**
	 * 将xombean对象转换为位于root下的一个xml子元素
	 */
	public Element getXML() {
		Element xombean = new Element("XomBean");
		Element first = new Element("first");
		first.appendChild(firstName);
		xombean.appendChild(first);
		Element last = new Element("last");
		last.appendChild(lastName);
		xombean.appendChild(lastName);
		return xombean;

	}
}
