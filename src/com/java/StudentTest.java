package com.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

/**
 * 事务的acid
 * 批处理
 * @author liukuijian
 *
 */
public class StudentTest {
	@Test
	public void test2() throws Exception {
		Connection connection = JDBCUtils.getConnection();
		String sql = "insert into student values(?,?,?,?);";
		PreparedStatement ps = connection.prepareStatement(sql);
		for(int i = 1; i <= 1000; i++) {
			ps.setInt(1, i);
			ps.setString(2, Math.random() > 0.5 ? "男":"女");
			ps.setString(3, i + "@qq");
			ps.setDouble(4, Math.random() * 100);
			ps.addBatch();
			if(i % 100 == 0) {
				ps.executeBatch();
				ps.clearBatch();
				System.out.println("完成：" + i / 1000.0 * 100 + "%");
			}
		}
		JDBCUtils.close(connection, ps);
	}
	@Test
	public void test(){
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = JDBCUtils.getConnection();
			connection.setAutoCommit(false);
			String sql = "update student set s_score = ? where s_id = ?";
			ps = connection.prepareStatement(sql);
			ps.setDouble(1, 59);
			ps.setInt(2, 11);
			ps.executeUpdate();
			
			System.out.println(1 / 0);
			
			ps.setDouble(1, 59);
			ps.setInt(2, 12);
			ps.executeUpdate();
			
			connection.commit();
		}catch(Exception e){
			System.out.println(e.getMessage());
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally {
			JDBCUtils.close(connection, ps);
		}
	}
}
