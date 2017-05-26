package com.qq986945193.javaweb.domain;

import java.io.File;
/**
 * 封装发送邮件的javabean
 */
public class AttachBean {
	private File file;
	private String fileName;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public AttachBean() {

	}

	public AttachBean(File file, String fileName) {
		super();
		this.file = file;
		this.fileName = fileName;
	}
}
