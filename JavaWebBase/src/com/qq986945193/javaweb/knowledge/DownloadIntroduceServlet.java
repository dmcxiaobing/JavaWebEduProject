package com.qq986945193.javaweb.knowledge;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.qq986945193.javaweb.utils.EncodingUtils;

/**
 *下载文件的功能简单介绍
 */
public class DownloadIntroduceServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 下载，两个头一个流 1,Content-Type,Content-Disposition 2,流；下载文件
		 */
		// 下载文件，所以这里不用WEB-INF目录
		String fileName = this.getServletContext().getRealPath("/download/") + "settings.jar";
		// 为了使下载框中显示中文文件不乱码
		String frameName = EncodingUtils.filenameEncoding(fileName, req);
		// 通过文件名称获取MIME类型
		String contentType = this.getServletContext().getMimeType(fileName);
		String contentDisposition = "attachment;filename=" + frameName;
		// 一个流
		FileInputStream inputStream = new FileInputStream(fileName);
		// 设置头
		resp.setHeader("Content-Type", contentType);
		resp.setHeader("Content-Disposition", contentDisposition);
		// 获取绑定了响应端的流
		ServletOutputStream outputStream = resp.getOutputStream();
		IOUtils.copy(inputStream, outputStream);
	}
}
