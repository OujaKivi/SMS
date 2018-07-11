package com.ouja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ouja.beans.*;
import com.ouja.utils.JdbcUtils;

public class StudentDaoImpl implements IStudentDao {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public Student selectStudentLogin(String num, String password) {
		// TODO Auto-generated method stub
		Student student=null;
		try {
					conn = JdbcUtils.getConnection();
		String sql="select * from student where num=? and password=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, num);
		ps.setString(2, password);

		rs=ps.executeQuery();
		if(rs.next()) {
			student = new Student();
			student.setId(rs.getInt("id"));
			student.setNum(rs.getString("num"));
			student.setPassword(rs.getString("password"));
			student.setName(rs.getString("name"));
			student.setAge(rs.getInt("age"));
			student.setScore(rs.getDouble("score"));
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtils.close(conn,ps,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return student;
	}
	@Override
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			conn=JdbcUtils.getConnection();
			String sql="insert into student (num,password,name,age,score) values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, student.getNum());
			ps.setString(2, student.getPassword());
			ps.setString(3, student.getName());
			ps.setInt(4,student.getAge());
			ps.setDouble(5, student.getScore());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}
