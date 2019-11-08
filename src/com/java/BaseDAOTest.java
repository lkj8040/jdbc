package com.java;

import java.util.List;

import org.junit.Test;

public class BaseDAOTest {
	/**
	 * 修改数据
	 * @throws Exception 
	 */
	@Test
	public void test3() throws Exception {
		BaseDAO baseDAO = new BaseDAO(); 
		String sql = "update student set s_score = 99.99 where s_id = ?";
		int update = baseDAO.update(sql, 10);
		System.out.println(update);
	}
	/**
	 * 查询一条数据
	 * @throws Exception 
	 */
	@Test
	public void test2() throws Exception {
		BaseDAO baseDAO = new BaseDAO();
		String sql = "select * from student where s_id = 10";
		Student student = baseDAO.query(sql, Student.class);
		System.out.println(student);
	}
	/**
	 * 查询
	 * @throws Exception 
	 */
	@Test
	public void test() throws Exception {
		
		BaseDAO baseDAO = new BaseDAO();
		String sql = "select * from student where s_score > ?";
		List<Student> list = baseDAO.query(sql, Student.class, 70);
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
