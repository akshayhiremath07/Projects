package com.getitdone.in.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.getitdone.in.dao.RegistrationDao;
import com.getitdone.in.dao.RegistrationDaoImpl;
import com.getitdone.in.dto.Employee;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RegistrationDao dao=new RegistrationDaoImpl();
		String eid = request.getParameter("eid");
		String ename =  request.getParameter("ename");
		String eage =  request.getParameter("eage");
		String email =  request.getParameter("email");
		String mobile =  request.getParameter("mobile");
		
		Employee employee=new Employee(eid,ename,Integer.parseInt(eage),email,mobile);
		String result = dao.addEmployee(employee);
		PrintWriter out = response.getWriter();
		if(result=="success") {
			out.println("<h1 style='color:green;text-align:center;'>Registration Successfull</h1>");
		}else {
			out.println("<h1 style='color:red;text-align:center;'>Registration Failed</h1>");
		}
         
		
		
	}

}
