package com.qq986945193.javaweb.servlet;
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qq986945193.javaweb.domain.AjaxJsonProvince;
import com.qq986945193.javaweb.utils.TxQueryRunner;

import net.sf.json.JSONArray;

/**
 * 请求数据库的json来实现ajax
 * 
 */
public class AjaxJsonProvinceServlet extends HttpServlet {
	private QueryRunner queryRunner = new TxQueryRunner();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		/**
		 * 这里省去了servie层和dao层直接操作数据库了。为了方便
		 */
		List<AjaxJsonProvince> provinces = findAllProvince();
		String json = JSONArray.fromObject(provinces).toString();
		System.err.println(json);
		response.getWriter().print(json);
	}

	/**
	 * 操作数据获取到所有省份名称
	 */
	private List<AjaxJsonProvince> findAllProvince() {
		String sql = "select * from t_province";
		try {
			return queryRunner.query(sql, new BeanListHandler<AjaxJsonProvince>(AjaxJsonProvince.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
