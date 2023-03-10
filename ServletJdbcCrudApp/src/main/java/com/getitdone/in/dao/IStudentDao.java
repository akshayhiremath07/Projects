package com.getitdone.in.dao;

import com.getitdone.in.model.Student;

public interface IStudentDao {
	
	public String addStudent(Student student);
	
	public Student searchStudent(int studentId);
	
	public String updateStudent(Student student);
	
	public String deleteStudent(int studentId);
}
