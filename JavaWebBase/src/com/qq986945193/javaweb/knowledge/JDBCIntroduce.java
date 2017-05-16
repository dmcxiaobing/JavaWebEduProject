package com.qq986945193.javaweb.knowledge;
/**
 * @Author ：程序员小冰
 * @GitHub: https://github.com/QQ986945193
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
/**
 * @Author ：程序员小冰
 * @GitHub: https://github.com/QQ986945193
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Driver;
import com.qq986945193.javaweb.dao.JDBCAccountDao;
import com.qq986945193.javaweb.utils.JdbcUtils;

/**
 * jdbc的一些简单的功能介绍
 */
public class JDBCIntroduce {

	@Test
	public void fun1() throws ClassNotFoundException, SQLException, IOException {
		java.sql.Connection connection = JdbcUtils.getConnection();
		// java.sql.Connection connection = getConnection();
		fun1(connection);
		// System.out.println(JdbcUtils.getConnection());
	}

	private void fun1(Connection connection) throws SQLException {
		if (connection != null) {
			// 不等于空，则说明连接成功 Statement是用来向数据库发送要执行的SQL语句的！
			/*
			 * 二、对数据库做增、删、改 1. 通过Connection对象创建Statement >
			 * Statement语句的发送器，它的功能就是向数据库发送sql语句！ 2. 调用它的int
			 * executeUpdate(String sql)，它可以发送DML、DDL
			 */
			Statement createStatement = connection.createStatement();
			String sqlString = "insert into user values ('lisis',22)";
			/**
			 * 执行sql语句 发送增删改语句
			 * 
			 */
			// createStatement.executeUpdate(sqlString);
			/**
			 * 发送查询的sql语句
			 */
			String sqlSelctString = "select * from emp";
			// 得到查询结果，然后将查询结果的内容读取出来

			ResultSet executeQuery = createStatement.executeQuery(sqlSelctString);
			// while (executeQuery.next()) {
			// String username = executeQuery.getString("name");
			// String password = executeQuery.getString("age");
			// System.out.println(username + "," + password);
			// }

			/*
			 * 三、解析ResultSet 1. 把行光标移动到第一行，可以调用next()方法完成！
			 */
			while (executeQuery.next()) {// 把光标向下移动一行，并判断下一行是否存在！
				int empno = executeQuery.getInt(1);// 通过列编号来获取该列的值！
				String ename = executeQuery.getString("ename");// 通过列名称来获取该列的值
				double sal = executeQuery.getDouble("sal");
				System.out.println(empno + ", " + ename + ", " + sal);
			}
			executeQuery.close();
			createStatement.close();
			connection.close();
		}

	}

	/**
	 * 加载驱动并进行获取连接 /** ClassNotFoundException找不到类 可能没导入驱动包
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 *             检查是否开启了mysql服务器以及用户名密码是否正确
	 */
	private java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
		/*
		 * jdbc四大配置参数： > driverClassName：com.mysql.j dbc.Driver >
		 * url：jdbc:mysql://localhost:3306/db3 > username：root > password：123
		 */
		/*
		 * 所有的java.sql.Driver实现类，都提供了static块，块内的代码就是把自己注册到 DriverManager中！
		 */
		/*
		 * jdbc4.0之后，每个驱动jar包中，在META-INF/services目录下提供了一个名为java.sql.Driver的文件。
		 * 文件的内容就是该接口的实现类名称！
		 */
		Class.forName("com.mysql.jdbc.Driver");
		// com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
		// DriverManager.registerDriver(driver);
		// 使用url、username、password，得到连接对象
		java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "1234");
		System.out.println(connection);
		return connection;
	}

	// 规范化 执行 查询操作
	@Test
	public void fun2() throws Exception {
		Connection con = null;// 定义引用
		Statement stmt = null;
		ResultSet rs = null;
		try {
			/*
			 * 一、得到连接
			 */
			con = JdbcUtils.getConnection();// 实例化

			/*
			 * 二、创建Statement
			 */
			stmt = con.createStatement();
			String sql = "select * from emp";
			// 执行查询操作
			rs = stmt.executeQuery(sql);

			rs.last();// 把光标移动到最后一行
			System.out.println(rs.getRow());
			rs.beforeFirst();

			/*
			 * 三、循环遍历rs，打印其中数据
			 * 
			 * getString()和getObject()是通用的！
			 */
			// while(rs.next()) {
			// System.out.println(rs.getObject(1) + ", "
			// + rs.getString("ename") + ", " + rs.getDouble("sal"));
			// }
			// 得到行数
			int count = rs.getMetaData().getColumnCount();
			while (rs.next()) {// 遍历行
				// 得到ename列的所有数据
				// System.out.println(rs.getString("ename"));
				for (int i = 1; i <= count; i++) {// 遍历列 从1开始
					System.out.print(rs.getString(i));
					if (i < count) {
						System.out.print(", ");
					}
				}
				System.out.println();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 关闭
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		}

	}

	/**
	 * 使用批处理操作数据库 开启mysql的批处理
	 */
	/**
	 * 1,用循环向preparedStatement添加sql参数，它自己有模板，使用一组参数与模板罚没可以匹配出一条sql语句
	 * 2,调用他的执行批处理方法，完成向数据库发送
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void funPreparedStatement() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = JdbcUtils.getConnection();
		String sql = "insert into t_stu values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		for (int i = 0; i < 10000; i++) {
			preparedStatement.setString(1, i + "");
			preparedStatement.setString(2, "stu_" + i);
			preparedStatement.setInt(3, i);
			// 添加批处理，这一组参数就保存到集合中了。
			preparedStatement.addBatch();
		}
		long start = System.currentTimeMillis();
		preparedStatement.execute();// 执行批处理
		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}

	/**
	 * 大数据，将MP3文件保存到数据库中
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void funBigData() throws ClassNotFoundException, IOException, SQLException {
		/**
		 * 得到connection，给出sql模板，创建preparestatement
		 * 设置sql模板中的参数，调用executeUpdata()执行
		 */
		Connection connection = JdbcUtils.getConnection();
		String sql = "insert into tab_bin values(?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, 1);
		/**
		 * 需要得到blob对象。我们有的是文件，可以将文件转为字节数组，然后在转为blob对象
		 */
		byte[] datas = IOUtils.toByteArray(new FileInputStream("d:/david.mp3"));
		SerialBlob blob = new SerialBlob(datas);
		preparedStatement.setBlob(2, blob);
		preparedStatement.executeUpdate();

	}

	/**
	 * 从数据库中读取文件
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void funReadFile() throws SQLException, ClassNotFoundException, IOException {
		// 获取connection
		Connection connection = JdbcUtils.getConnection();
		// 查询出文件
		String sql = "select * from tab_bin";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		// 遍历resultSet
		if (resultSet.next()) {
			Blob blob = (Blob) resultSet.getBlob("data");
			// 通过blob变成硬盘的文件
			InputStream inputStream = blob.getBinaryStream();
			OutputStream outputStream = new FileOutputStream("d:/david.mp3");
			IOUtils.copy(inputStream, outputStream);
		}
	}

	/**
	 * 利用转账的代码来展示事务的功能
	 */
	public void funAutoCommit() {
		Connection connection = null;
		// 这是转钱的人，付款人
		String fromUser = "zhangsan";
		// 这是收钱人
		String toUser = "lisi";
		// 这是要转的钱数
		Double banlance = (double) 200;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getC3P0Connection();
			// 手动开启事务，提交
			connection.setAutoCommit(false);
			/**
			 * 这里操作数据库 依靠dao数据库层
			 */
			JDBCAccountDao dao = new JDBCAccountDao();
			dao.updateBalance(fromUser,toUser,banlance,preparedStatement);
			connection.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 提交事务异常，则回滚
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {

			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block

			}
		}
	}

}
