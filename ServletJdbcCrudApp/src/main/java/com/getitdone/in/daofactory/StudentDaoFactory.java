package com.getitdone.in.daofactory;

import com.getitdone.in.dao.IStudentDao;
import com.getitdone.in.dao.StudentDaoImpl;

public class StudentDaoFactory {
   
	static IStudentDao studentDao=null;
	public static IStudentDao getStudentDao() {
		if(studentDao==null) {
			studentDao=new StudentDaoImpl();
		}
		return studentDao;
	}
	
}
