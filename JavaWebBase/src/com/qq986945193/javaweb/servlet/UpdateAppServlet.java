package com.qq986945193.javaweb.servlet;
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.qq986945193.javaweb.domain.UpdateAppBean;
import com.qq986945193.javaweb.domain.UpdateAppNoListBean;
import com.qq986945193.javaweb.utils.PathUtils;

/**
 * 升级app版本的一个功能
 * http://localhost:8080/javaweb/servlet/UpdateAppServlet
 */
public class UpdateAppServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 处理客户端的post以及get请求，并设置编码
//		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String DOWNLOAD_APK_URL = "";
		DOWNLOAD_APK_URL = "http://192.168.1.36:8080"+request.getContextPath()+"/download/dandroid.apk";
		System.out.println(DOWNLOAD_APK_URL);
		/**
		 * 这里直接返回数据 假如有新版本
		 */
		PrintWriter writer = response.getWriter();
		UpdateAppBean mUpdateAppBean = new UpdateAppBean();
		List<UpdateAppBean.MsgBean> msgBeans = new ArrayList<UpdateAppBean.MsgBean>();
		UpdateAppBean.MsgBean msgBean = new UpdateAppBean.MsgBean();
		try {
			BeanUtils.setProperty(mUpdateAppBean, "status", "success");
			BeanUtils.setProperty(msgBean, "description", "你好。this is app description");
			BeanUtils.setProperty(msgBean, "downloadApkUrl", DOWNLOAD_APK_URL);
			BeanUtils.setProperty(msgBean, "versionCode", "2");
			msgBeans.add(msgBean);
			BeanUtils.setProperty(mUpdateAppBean, "msg", msgBeans);
			Gson gson = new Gson();
			String jsonValue = gson.toJson(mUpdateAppBean);
			System.out.println(jsonValue);
			writer.print(jsonValue);
			writer.flush();
		} catch (Exception e) {
			System.out.println("异常了"+e.getMessage());
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

}
