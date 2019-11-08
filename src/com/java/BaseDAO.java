package com.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class BaseDAO {
	private QueryRunner qr = new QueryRunner();
	
	public <T> List<T> query(String sql, Class<T> clazz, Object... params) throws Exception{
		Connection connection = JDBCUtils.getConnection();
		List<T> list = qr.query(connection, sql, new BeanListHandler<T>(clazz), params);
		connection.close();
		return list;
	}
	
	public <T> T query(String sql, Class<T> clazz) throws Exception {
		Connection connection = JDBCUtils.getConnection();
		T t = qr.query(connection, sql, new BeanHandler<T>(clazz));
		connection.close();
		return t;
	}
	
	public int update(String sql, Object...params) throws Exception {
		Connection connection = JDBCUtils.getConnection();
		int update = qr.update(connection, sql, params);
		connection.close();
		return update;
	}
}
