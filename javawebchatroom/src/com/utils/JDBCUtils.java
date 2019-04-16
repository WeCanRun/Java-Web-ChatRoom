package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC工具类:
 * 	* 加载驱动
 *  * 获得连接
 *  * 释放资源
 *  * 代码都重复.
 * 
 *
 */
public class JDBCUtils {
	
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	// 获得连接池:
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	// 获得连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
