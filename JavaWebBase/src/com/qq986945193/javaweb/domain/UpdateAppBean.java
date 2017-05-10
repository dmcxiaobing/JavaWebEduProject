package com.qq986945193.javaweb.domain;

import java.util.List;

/**
 * 一个更新的javabean
 */
public class UpdateAppBean {
	/*
	 * { "_ticket": "jl4f3k6ha45bqlt1vttnr7m252", "msg": { "apiVersion":
	 * "210000", "description": "【更新说明】 1. 修复已知BUG 2.修复已知BUG 3.提升用户流畅度 4.
	 * 修复已知BUG", "downloadUrl": "http://www.david.com/java.apk", "versionCode":
	 * "3", "versionName": "1.2" }, "status": "success" }
	 */

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<MsgBean> getMsg() {
		return msg;
	}

	public void setMsg(List<MsgBean> listsMsgBeans) {
		this.msg = listsMsgBeans;
	}

	private List<MsgBean> msg;

	public static class MsgBean {
		private String description;
		private String downloadApkUrl;
		private String versionCode;

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getDownloadApkUrl() {
			return downloadApkUrl;
		}

		public void setDownloadApkUrl(String downloadApkUrl) {
			this.downloadApkUrl = downloadApkUrl;
		}

		public String getVersionCode() {
			return versionCode;
		}

		public void setVersionCode(String versionCode) {
			this.versionCode = versionCode;
		}

	}
}
