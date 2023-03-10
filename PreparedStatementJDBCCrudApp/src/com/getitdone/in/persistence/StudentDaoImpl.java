package com.getitdone.in.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.getitdone.in.dto.Student;
import com.getitdone.in.util.jdbcUtil;

public class StudentDaoImpl implements IStudentDao {
	
	Connection connection=null;

	@Override
	public String addStudent(String name, int age, String address) {
		PreparedStatement prepareStatement =null;
	      try {
			connection=jdbcUtil.getJdbcConnection();
			
			String sqlQuery="insert into student(`sname`,sage,`saddress`)values(?,?,?)";
			prepareStatement= connection.prepareStatement(sqlQuery);
			
			prepareStatement.setString(1, name);
			prepareStatement.setInt(2, age);
			prepareStatement.setString(3, address);
			
			int rowCount=prepareStatement.executeUpdate();
			if(rowCount==1) return "success";
			 
			
		} catch (IOException | SQLException e) {
			
			e.printStackTrace();
		}
	      return "failure";
	}

	@Override
	public Student searchStudent(int studentId) {
		Student student=null;
		PreparedStatement prepareStatement=null;
		ResultSet executeQuery=null;
		try {
			connection=jdbcUtil.getJdbcConnection();
			
			String sqlQuery="select sid,sname,sage,saddress from student where sid=?";
			prepareStatement= connection.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, studentId);
			executeQuery= prepareStatement.executeQuery();
			student=new Student();
			if(executeQuery.next()) {
			Integer id=executeQuery.getInt(1);
			String name=executeQuery.getString(2);
			Integer age=executeQuery.getInt(3);
			String address=executeQuery.getString(4);
			
		student.setSid(id);
		student.setSaddress(address);
		student.setSage(age);
		student.setSname(name);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return student;
	   
	}

	@Override
	public String updateStudent(Student student) {
		 PreparedStatement prepareStatement=null;
		 try {
				connection=jdbcUtil.getJdbcConnection();
				
				String sqlQuery="update student set sname=?,sage=?,saddress=? where sid=?";
				prepareStatement= connection.prepareStatement(sqlQuery);
				
				prepareStatement.setString(1, student.getSname());
				prepareStatement.setInt(2, student.getSage());
				prepareStatement.setString(3, student.getSaddress());
				prepareStatement.setInt(4, student.getSid());
				
				int rowCount=prepareStatement.executeUpdate();
				if(rowCount==1) return "success";
				 
				
			} catch (IOException | SQLException e) {
				
				e.printStackTrace();
			}
		      return "failure";
	}

	@Override
	public String deleteStudent(int studentId) {
		PreparedStatement pstmt=null;
    	try {
			connection=jdbcUtil.getJdbcConnection();
			
			pstmt=connection.prepareStatement("delete from student where sid=?");
			pstmt.setInt(1, studentId);
			int rowCount = pstmt.executeUpdate();
			if(rowCount==1) return "success";
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}


    

}
