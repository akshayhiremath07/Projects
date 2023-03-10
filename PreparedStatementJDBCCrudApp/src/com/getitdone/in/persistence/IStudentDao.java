package com.getitdone.in.persistence;

import com.getitdone.in.dto.Student;

public interface IStudentDao {
	
	public String addStudent(String name,int age,String address);
	
	public Student searchStudent(int studentId);
	
	public String updateStudent(Student student);
	
	public String deleteStudent(int studentId);
}
