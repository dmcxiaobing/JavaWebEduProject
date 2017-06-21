package com.qq986945193.javaweb.servlet.day11;
/**
 * @Author ：程序员小冰
 * @GitHub: https://github.com/QQ986945193
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq986945193.javaweb.servlet.BaseServlet;
import com.qq986945193.javaweb.utils.FileUtils;

/**
 * 网络硬盘的小功能 查看上传的文件列表
 */
public class UploadFileServlet extends BaseServlet {

	private List<String> listsName = new ArrayList<String>();

	/**
	 * 查看所有的文件
	 * 
	 * @param request
	 * @param response
	 * @return uploadFileList.jsp
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response) {
		// 得到文件保存的路径
		String rootPath = this.getServletContext().getRealPath("/WEB-INF/files");
		ArrayList<File> files = FileUtils.getListFiles(rootPath);
		for (int i = 0; i < files.size(); i++) {
			listsName.add(files.get(i).getName());
		}
		request.setAttribute("lists", listsName);
		return "f:/jsps/uploadFileList.jsp";

	}
}
