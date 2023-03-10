package com.getitdone.in.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.getitdone.in.model.Student;
import com.getitdone.in.service.IStudentService;
import com.getitdone.in.servicefactory.StudentServiceFactory;

@WebServlet("/controller/*")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {

		IStudentService stdService = StudentServiceFactory.getStudentService();

		if (request.getRequestURI().endsWith("/addform")) {

			String name = request.getParameter("sname");
			String age = request.getParameter("sage");
			String addr = request.getParameter("saddr");

			Student student = new Student();
			student.setSname(name);
			student.setSaddress(addr);
			student.setSage(Integer.parseInt(age));
			String result = stdService.addStudent(student);
			PrintWriter out = response.getWriter();
			if (result.equalsIgnoreCase("success")) {
				out.println("<h1>REGISTRATION SUCCESSFULL.");
			} else {
				out.println("<h1>REGISTRATION FAILED.");
			}

		}
		if (request.getRequestURI().endsWith("/searchform")) {
			String id = request.getParameter("sid");

			Student student = stdService.searchStudent(Integer.parseInt(id));
			PrintWriter out = response.getWriter();
			if (student.getSid() != null) {
				out.println("<table border=1>" + "<tr><th>id</th><td>" + student.getSid() + "</td></tr>"
						+ "<tr><th>name</th><td>" + student.getSname() + "</td></tr>" + "<tr><th>age</th><td>"
						+ student.getSage() + "</td></tr>" + "<tr><th>address</th><td>" + student.getSaddress()
						+ "</td></tr>" + "</table>");
			} else {
				out.println("<h1>STUDENT RECHORD NOT FOUND</h1>");
			}

		}
		if (request.getRequestURI().endsWith("/deleteform")) {
			PrintWriter out = response.getWriter();
			String result = stdService.deleteStudent(Integer.parseInt(request.getParameter("sid")));
			if (result.equalsIgnoreCase("success")) {
				out.println("<h1>DELETION SUCCESSFULL.");
			} else {
				out.println("<h1>DELETION FAILED.");
			}
		}
		if (request.getRequestURI().endsWith("editform")) {
			String sid = request.getParameter("sid");

			Student student = stdService.searchStudent(Integer.parseInt(sid));
			PrintWriter out = response.getWriter();
			if (student != null) {
				// display student records as a form data so it is editable
				out.println("<body>");
				out.println("<center>");
				out.println("<form method='post' action='./controller/updateRecord'>");
				out.println("<table>");
				out.println("<tr><th>ID</th><td>" + student.getSid() + "</td></tr>");
				out.println("<input type='hidden' name='sid' value='" + student.getSid() + "'/>");
				out.println("<tr><th>NAME</th><td><input type='text' name='sname' value='" + student.getSname()
						+ "'/></td></tr>");
				out.println("<tr><th>AGE</th><td><input type='text' name='sage' value='" + student.getSage()
						+ "'/></td></tr>");
				out.println("<tr><th>ADDRESS</th><td><input type='text' name='saddr' value='" + student.getSaddress()
						+ "'/></td></tr>");
				out.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");
			} else {
				// display not found message
				out.println("<body>");
				out.println("<h1 style='color:red;text-align:center;'>Record not avaialable for the give id :: " + sid
						+ "</h1>");
				out.println("</body>");
			}
			out.close();
		}
		if (request.getRequestURI().endsWith("updateRecord")) {
			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddr = request.getParameter("saddr");

			Student student = new Student();
			student.setSid(Integer.parseInt(sid));
			student.setSaddress(saddr);
			student.setSname(sname);
			student.setSage(Integer.parseInt(sage));

			String status = stdService.updateStudent(student);
			PrintWriter out = response.getWriter();

			if (status.equals("success")) {
				out.println("<h1 style=' text-align:center;'>STUDENT RECORD UPDATED SUCCESSFULLY</h1>");
			} else {
				out.println("<h1 style='color:green; text-align:center;'>STUDENT RECORD UPDATION FAILED</h1>");
			}
			out.close();

		}

	}
}
