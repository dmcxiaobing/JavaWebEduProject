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

import com.google.gson.JsonArray;
import com.qq986945193.javaweb.domain.AjaxJsonCity;
import com.qq986945193.javaweb.utils.TxQueryRunner;

import net.sf.json.JSONArray;
/**
 * ajax根据省份获取到市区列表
 */
public class AjaxJsonCityServlet extends HttpServlet {

	private QueryRunner queryRunner = new TxQueryRunner();
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		/**
		 * 获取名为pid的参数。使用这个省的id查询数据库。得到city的集合
		 * 转发成json，发送给客户端
		 */
		System.out.println("f:"+request.getParameter("pid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		List<AjaxJsonCity> citys = findByPid(pid);
		System.out.println(citys.size());
		String json = JSONArray.fromObject(citys).toString();
		System.out.println(json);
		response.getWriter().print(json);
	}
	/**
	 * 根据pid查询市区的列表 为了方便，省去了servie和dao层
	 */
	private List<AjaxJsonCity> findByPid(int pid) {
		String sql = "select * from t_city where pid = ?";
		try {
			return queryRunner.query(sql, new BeanListHandler<AjaxJsonCity>(AjaxJsonCity.class),pid);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
