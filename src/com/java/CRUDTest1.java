package com.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import org.junit.Test;

public class CRUDTest1 {
	
	
	/**
	 * insert数据
	 * @throws Exception 
	 */
	@Test
	public void test3() throws Exception {
		Connection connection = JDBCUtils.getConnection();
		String sql = "insert into student values(?,?,?,?);";
		PreparedStatement ps = connection.prepareStatement(sql);
		for(int i = 1; i < 100; i++) {
			ps.setInt(1, i);
			ps.setString(2, "男");
			ps.setString(3, i + "@qq.com");
			ps.setDouble(4, Math.random()*100);
			ps.executeUpdate();
		}
		JDBCUtils.close(connection, ps);
	}
	
	/**
	 * update、delete、insert数据
	 * @throws Exception 
	 */
	@Test
	public void test2() throws Exception {
		Connection connection = JDBCUtils.getConnection();
		String sql = "update student set s_email = 'erha.com' where s_id = ?" ;
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, 1);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		JDBCUtils.close(connection, ps);
	}
	
	/**
	 * 查询数据
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		Connection connection = JDBCUtils.getConnection();
		String sql = "select first_name,job_id,salary from employees where department_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, 50);
		ResultSet resultSet = ps.executeQuery();
		while(resultSet.next()) {
			String first_name = resultSet.getString("first_name");
			String job_id = resultSet.getString(2);
			double salary = resultSet.getDouble("salary");
			System.out.println(first_name + " " + job_id + " " + salary);
		}
		JDBCUtils.close(connection, ps, resultSet);
	}
}
