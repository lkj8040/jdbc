package com.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import com.mysql.jdbc.Driver;

/**
 *  	目录：
 		1.通过Driver和DriverManager获取数据库连接   Driver  DriverManager  读配置文件
 		2.通过Druid（连接池）获取数据库连接  DruidDataSourceFactory.createDataSource
 		3.对数库进行CRUD的操作
 		4.通过DBUtils对数据库进行CRUD的操作
 		5.封装BaseDAO
 		6.事务
 		7.Statment使用的问题(sql注入的问题)
 		8.批处理
 * @author liukuijian
 *
 */
public class DriverTest {
	@Test
	public void test3() throws Exception {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("jdbc.properties");
		properties.load(fis);
		String username = properties.getProperty("user");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		String driver = properties.getProperty("driver");
		Class clazz = Class.forName(driver);
		Driver dr = (Driver)clazz.newInstance();
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println(connection);
	}
	
	@Test
	public void test2() throws Exception {
		Class forName = Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees", "root", "root");
		System.out.println(connection);
		connection.close();
	}
	
	@Test
	public void test() throws Exception {
		Driver dr = new com.mysql.jdbc.Driver();
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("jdbc.properties");
		properties.load(fis);
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		String driver = properties.getProperty("driver");
		Connection connection = dr.connect(url, properties);
		System.out.println(connection);
		connection.close();
	}
}
