package com.getitdone.in.service;

import com.getitdone.in.model.Student;

public interface IStudentService {
	
	

	public Student searchStudent(Integer sid);

	public String updateStudent(Student student);

	public String deleteStudent(Integer sid);

	public String addStudent(Student student);
}
