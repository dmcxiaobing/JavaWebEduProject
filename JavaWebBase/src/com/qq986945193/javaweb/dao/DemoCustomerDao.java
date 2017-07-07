package com.qq986945193.javaweb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qq986945193.javaweb.domain.DemoCustomerBean;
import com.qq986945193.javaweb.domain.DemoPageBean;
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
			 * 1. 给出sql模板 2. 给出参数 3. 调用query方法，使用结果集处理器：BeanListHandler
			 */
			/*
			 * 一、 给出sql模板 二、 给出参数！
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
			 */
			List<Object> params = new ArrayList<Object>();
			String cname = customerBean.getCname();
			if (cname != null && !cname.trim().isEmpty()) {
				// 拼接sql语句
				sql.append(" and cname like ?");
				// 添加参数 放到集合中
				params.add("%" + cname + "%");
			}
			String gender = customerBean.getGender();
			if (gender != null && !gender.trim().isEmpty()) {
				sql.append(" and gender = ?");
				params.add(gender);
			}

			String cellPhone = customerBean.getCellphone();
			if (cellPhone != null && !cellPhone.trim().isEmpty()) {
				sql.append(" and cellPhone = ?");
				params.add("%" + cellPhone + "%");
			}
			String email = customerBean.getEmail();
			if (email != null && !email.trim().isEmpty()) {
				sql.append(" and email = ?");
				params.add("%" + email + "%");
			}

			return queryRunner.query(sql.toString(), new BeanListHandler<DemoCustomerBean>(DemoCustomerBean.class),
					params.toArray());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据当前页和每页记录数查询数据
	 * 
	 * @param pc
	 *            当前页
	 * @param ps
	 *            每页记录数
	 * @throws SQLException
	 */
	public DemoPageBean<DemoCustomerBean> findByPage(int pc, int ps) throws SQLException {
		String sql = "select count(*) from demo_tb_customer ";
		// 总记录数
		int tr = ((Number) queryRunner.query(sql, new ScalarHandler())).intValue();
		// 当前页和每页的数量。
		sql = "select * from demo_tb_customer limit ? ,?";
		List<DemoCustomerBean> customerLists = queryRunner.query(sql,
				new BeanListHandler<DemoCustomerBean>(DemoCustomerBean.class), (pc - 1) * ps, ps);
		DemoPageBean<DemoCustomerBean> pageBean = new DemoPageBean<DemoCustomerBean>();
		pageBean.setDatas(customerLists);
		pageBean.setPc(pc);
		pageBean.setPs(ps);
		pageBean.setTr(tr);
		return pageBean;
	}

	/**
	 * 高级组合查询，记录数
	 */
	public int pageCountQuery(DemoCustomerBean customerBean) {
		// 定义查询的sql语句
		String sql = "select count(*) from demo_tb_customer where 1 = 1";
		StringBuilder sb = new StringBuilder(sql);
		// 所需要的参数值
		List<Object> params = new ArrayList<Object>();
		String cname = customerBean.getCname();
		if (cname != null && !cname.trim().isEmpty()) {
			sb.append(" and cname like ?");
			params.add("%" + cname + "%");
		}
		String gender = customerBean.getGender();
		if (gender != null && !gender.trim().isEmpty()) {
			sb.append(" and gender = ?");
			params.add(gender);
		}
		String cellphone = customerBean.getCellphone();
		if (cellphone != null && !cellphone.trim().isEmpty()) {
			sb.append(" and cellphone like ?");
			params.add("%" + cellphone + "%");
		}
		String email = customerBean.getEmail();
		if (email != null && !email.trim().isEmpty()) {
			sb.append(" and email like ?");
			params.add("%" + email + "%");
		}
		try {
			Long count = (Long) queryRunner.query(sb.toString(), new ScalarHandler(), params.toArray());
			return count.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * 获取datas,即当前页记录 .从第几条记录查询，一共查询多少条记录
	 */
	public List<DemoCustomerBean> queryByPage(DemoCustomerBean formCustomerBean, int index, int ps) {
		try {
			/*
			 * 1. 给出sql模板 2. 给出参数 3. 调用query方法，使用结果集处理器：BeanListHandler
			 */
			/*
			 * 一、 给出sql模板 二、 给出参数！
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
			 */
			List<Object> params = new ArrayList<Object>();
			String cname = formCustomerBean.getCname();
			if (cname != null && !cname.trim().isEmpty()) {
				// 拼接sql语句
				sql.append(" and cname like ?");
				// 添加参数 放到集合中
				params.add("%" + cname + "%");
			}
			String gender = formCustomerBean.getGender();
			if (gender != null && !gender.trim().isEmpty()) {
				sql.append(" and gender = ?");
				params.add(gender);
			}

			String cellPhone = formCustomerBean.getCellphone();
			if (cellPhone != null && !cellPhone.trim().isEmpty()) {
				sql.append(" and cellPhone = ?");
				params.add("%" + cellPhone + "%");
			}
			String email = formCustomerBean.getEmail();
			if (email != null && !email.trim().isEmpty()) {
				sql.append(" and email = ?");
				params.add("%" + email + "%");
			}

			sql.append(" limit ?,?");
			params.add(index);
			params.add(ps);
			return queryRunner.query(sql.toString(), new BeanListHandler<DemoCustomerBean>(DemoCustomerBean.class),
					params.toArray());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
