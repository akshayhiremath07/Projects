package com.getitdone.in.daofactory;

import com.getitdone.in.persistence.IStudentDao;
import com.getitdone.in.persistence.StudentDaoImpl;

public class StudentDaoFactory {
   
	static IStudentDao studentDao=null;
	public static IStudentDao getStudentDao() {
		if(studentDao==null) {
			studentDao=new StudentDaoImpl();
		}
		return studentDao;
	}
	
}
