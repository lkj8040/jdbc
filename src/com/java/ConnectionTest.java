package com.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

/**
 *  	目录：
 		1.通过Driver和DriverManager获取数据库连接
 		2.通过Druid（连接池）获取数据库连接
 		3.对数库进行CRUD的操作
 		4.通过DBUtils对数据库进行CRUD的操作
 		5.封装BaseDAO
 		6.事务
 		7.Statment使用的问题(sql注入的问题)
 		8.批处理
 * @author liukuijian
 *
 */
public class ConnectionTest {
	@Test
	public void test2() throws Exception {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("druid.properties");
		properties.load(fis);
		
		DataSource ds = DruidDataSourceFactory.createDataSource(properties);
		
		Connection connection = ds.getConnection();
		
		System.out.println(connection);
	}
	@Test
	public void test() throws Exception {
		DruidDataSource dds = new DruidDataSource();
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("druid.properties");
		properties.load(fis);
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		String driver = properties.getProperty("driver");
		dds.setUrl(url);
		dds.setUsername(username);
		dds.setPassword(password);
		dds.setDriverClassName(driver);
		Connection connection = dds.getConnection();
		System.out.println(connection);
	}
}
