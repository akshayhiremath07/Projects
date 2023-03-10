package com.getitdone.in.servicefactory;

import com.geitdone.in.service.IStudentService;
import com.geitdone.in.service.StudentServiceImpl;

public class StudentServiceFactory {
	
	private StudentServiceFactory(){
		
	}
	static IStudentService studentService=null;
	
	public static IStudentService getStudentService() {
		if(studentService==null) {
			studentService=new StudentServiceImpl();
		}
		return studentService;
	}

}
