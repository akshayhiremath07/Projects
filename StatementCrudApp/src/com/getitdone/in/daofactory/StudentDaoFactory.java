package com.getitdone.in.daofactory;

import com.geitdone.in.persistance.IStudentDao;
import com.geitdone.in.persistance.StudentDaoImpl;

public class StudentDaoFactory {
   
	static IStudentDao studentDao=null;
	public static IStudentDao getStudentDao() {
		if(studentDao==null) {
			studentDao=new StudentDaoImpl();
		}
		return studentDao;
	}
	
}
