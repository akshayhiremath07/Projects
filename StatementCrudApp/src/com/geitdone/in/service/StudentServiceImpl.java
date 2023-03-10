package com.geitdone.in.service;

import com.geitdone.in.dto.Student;
import com.geitdone.in.persistance.IStudentDao;
import com.getitdone.in.daofactory.StudentDaoFactory;

public class StudentServiceImpl implements IStudentService {
    
	IStudentDao studentDao=StudentDaoFactory.getStudentDao();
	
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		String msg=studentDao.addStudent(sname, sage, saddress);
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

