package com.geitdone.in.persistance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.geitdone.in.dto.Student;
import com.getitdone.in.util.jdbcUtil;

public class StudentDaoImpl implements IStudentDao {
	
	Connection connection=null;
	

	@Override
	public String addStudent(String name, int age, String address) {
		Statement statement =null;
	      try {
			connection=jdbcUtil.getJdbcConnection();
			statement = connection.createStatement();
//			String sqlQuery = "insert into student(`sname`,`sage`,`saddress`)values('hardhik',32,'GT')";
			String sqlInsertQuery = "insert into student(`sname`,`sage`,`saddress`)values('"+name+"','"+age+"','"+address+"')";
			
			int rowCount=statement.executeUpdate(sqlInsertQuery);
			if(rowCount==1) return "success";
			 
			
		} catch (IOException | SQLException e) {
			
			e.printStackTrace();
		}
	      return "failure";
	}

	@Override
	public Student searchStudent(int studentId) {
		Student student=null;
		Statement statement=null;
		ResultSet executeQuery=null;
		try {
			connection=jdbcUtil.getJdbcConnection();
			
			String sqlQuery="select sid,sname,sage,saddress from student where sid="+studentId;
			statement= connection.createStatement();
			executeQuery = statement.executeQuery(sqlQuery);
			
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
		
		 Statement statement=null;
		 try {
				connection=jdbcUtil.getJdbcConnection();
				statement = connection.createStatement();
	
				String sqlQuery="update student set sname='"+student.getSname()+"',sage="+student.getSage()+",saddress='"+student.getSaddress()+"' where sid="+student.getSid();
			  statement= connection.prepareStatement(sqlQuery);
				
				
				
				int rowCount=statement.executeUpdate(sqlQuery);
				if(rowCount==1) return "success";
				 
				
			} catch (IOException | SQLException e) {
				
				e.printStackTrace();
			}
		      return "failure";
	}

	@Override
	public String deleteStudent(int studentId) {
		Statement statement=null;
    	try {
			connection=jdbcUtil.getJdbcConnection();
			
			statement=connection.createStatement();
		    
			String query="delete from student where sid="+studentId;
			
			int rowCount = statement.executeUpdate(query);
			if(rowCount==1) return "success";
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}


    

}
