package com.qq986945193.javaweb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qq986945193.javaweb.domain.DemoCustomerBean;
import com.qq986945193.javaweb.utils.TxQueryRunner;

/**
 * 客户管理系统的持久层
 */
public class DemoCustomerDao {

	private QueryRunner queryRunner = new TxQueryRunner();

	/**
	 * 添加客户
	 * 
	 * @param customerBean
	 *            要存入数据库的bean
	 */
	public void add(DemoCustomerBean customerBean) {
		try {
			String sql = "insert into demo_tb_customer values (?,?,?,?,?,?,?)";
			Object[] params = { customerBean.getCid(), customerBean.getCname(), customerBean.getBirthday(),
					customerBean.getGender(), customerBean.getCellphone(), customerBean.getEmail(),
					customerBean.getDescription() };
			queryRunner.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询所有客户
	 */
	public List<DemoCustomerBean> findAll() {
		try {
			String sql = "select * from demo_tb_customer";
			return queryRunner.query(sql, new BeanListHandler<DemoCustomerBean>(DemoCustomerBean.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据cid查询出客户信息
	 *
	 */
	public DemoCustomerBean findByCid(String cid) {
		try {
			String sql = "select * from demo_tb_customer where cid = ?";
			return queryRunner.query(sql, new BeanHandler<DemoCustomerBean>(DemoCustomerBean.class), cid);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 编辑之后保存的方法
	 */
	public void editSave(DemoCustomerBean customerBean) {
		try {
			System.out.println(customerBean);
			String sql = "update demo_tb_customer set cname = ?," + "birthday=?," + "gender=?," + "cellphone = ?,"
					+ "email=?," + "description=? where cid = ?";
			Object[] params = { customerBean.getCname(), customerBean.getBirthday(), customerBean.getGender(),
					customerBean.getCellphone(), customerBean.getEmail(), customerBean.getDescription(),
					customerBean.getCid() };
			queryRunner.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 高级搜索，根据条件进行搜索客户
	 */
	public List<DemoCustomerBean> query(DemoCustomerBean customerBean) {
		try {
			/*
			 * 1. 给出sql模板
			 * 2. 给出参数
			 * 3. 调用query方法，使用结果集处理器：BeanListHandler
			 */
			/*
			 * 一、　给出sql模板
			 * 二、　给出参数！
			 */
			/*
			 * 1. 给出一个sql语句前半部
			 */
			StringBuilder sql = new StringBuilder("select * from demo_tb_customer where 1=1");
			/*
			 * 2. 判断条件，完成向sql中追加where子句
			 */
			/*
			 * 3. 创建一个ArrayList，用来装载参数值
			 * 
			 * */
			List<Object> params = new ArrayList<Object>();
			String cname = customerBean.getCname();
			if (cname!=null && !cname.trim().isEmpty()) {
				//拼接sql语句
				sql.append(" and cname like ?");
				//添加参数 放到集合中
				params.add("%"+cname+"%");
			}
			String gender = customerBean.getGender();
			if (gender!=null && !gender.trim().isEmpty()) {
				sql.append(" and gender = ?");
				params.add(gender);
			}
			
			String cellPhone = customerBean.getCellphone();
			if (cellPhone!=null && !cellPhone.trim().isEmpty()) {
				sql.append(" and cellPhone = ?");
				params.add("%"+cellPhone+"%");
			}
			String email = customerBean.getEmail();
			if (email!=null && !email.trim().isEmpty()) {
				sql.append(" and email = ?");
				params.add("%"+email+"%");
			}
			
			return queryRunner.query(sql.toString(), new BeanListHandler<DemoCustomerBean>(DemoCustomerBean.class),params.toArray());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
