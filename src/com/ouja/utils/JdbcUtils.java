package com.ouja.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	//加载DB驱动
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static Connection conn;
	//获取connection对象
	public static Connection getConnection() throws SQLException {
		
			String url="jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
			String user="root";
			String password="root";
			if (conn==null) {
				conn=DriverManager.getConnection(url,user,password);
			}
			return conn;
	}
	//关闭资源
	public static void close(Connection conn,Statement stmt,ResultSet rs) throws SQLException {

			if(conn!=null&&conn.isClosed()) {
				conn.close();
			}
			if(stmt!=null&&stmt.isClosed()) {
				stmt.close();
			}
			if(rs!=null&&rs.isClosed()) {
				rs.close();
			}

	}
	
}
