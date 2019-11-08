package com.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

public class CRUDTest2 {
	static QueryRunner qr = null;
	static {
		qr = new QueryRunner();
	}
	/**
	 * 删除
	 * @throws Exception 
	 */
	@Test
	public void test2() throws Exception {
		Connection connection = JDBCUtils.getConnection();
		String sql = "delete from student where s_score < ?";
		int update = qr.update(connection, sql, 50);
		System.out.println(update);
		connection.close();
	}
	
	/**
	 * 查询
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		Connection connection = JDBCUtils.getConnection();
		String sql = "select * from student where s_score > ?";
		List<Student> list = qr.query(connection, sql, new BeanListHandler<Student>(Student.class), 60);
		for (Student student : list) {
			System.out.println(student);
		}
		connection.close();
	}
}
