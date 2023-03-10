package com.getitdone.in.service;

import com.getitdone.in.dao.IStudentDao;
import com.getitdone.in.daofactory.StudentDaoFactory;
import com.getitdone.in.model.Student;

public class StudentServiceImpl implements IStudentService {
    
	IStudentDao studentDao=StudentDaoFactory.getStudentDao();
	
	@Override
	public String addStudent(Student student) {
		String msg=studentDao.addStudent(student);
		if(msg.equalsIgnoreCase("success"))
		return "success";
		else 
			return "failure";
	}

	@Override
	public Student searchStudent(Integer sid) {
		Student student = studentDao.searchStudent(sid);
		return student;
	}

	@Override
	public String updateStudent(Student student) {
		
		return studentDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer sid) {
		
		return studentDao.deleteStudent(sid);
	}
 
	
	
	
}

