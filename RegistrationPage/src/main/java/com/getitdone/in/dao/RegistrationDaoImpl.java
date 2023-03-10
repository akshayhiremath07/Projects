package com.getitdone.in.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.getitdone.in.dto.Employee;

public class RegistrationDaoImpl implements RegistrationDao {
	
	private Connection connection=null;
	private PreparedStatement statement=null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	public String addEmployee(Employee employee) {
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root123");
		    statement = connection.prepareStatement("insert into employee(`eid`,`ename`,`eage`,`email`,`mobile`)values(?,?,?,?,?);");
		     statement.setString(1, employee.getEid());
		     statement.setString(2, employee.getEname());
		     statement.setInt(3, employee.getAge());
		     statement.setString(4, employee.getEmail());
		     statement.setString(5, employee.getMobile());
		     int count = statement.executeUpdate();
		     if(count==1) {
		    	 return "success";
		     }
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return "failur";
		
	}


	
	

}
