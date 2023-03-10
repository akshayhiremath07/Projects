package com.getitdone.in.servicefactory;

import com.getitdone.in.service.IStudentService;
import com.getitdone.in.service.StudentServiceImpl;

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
