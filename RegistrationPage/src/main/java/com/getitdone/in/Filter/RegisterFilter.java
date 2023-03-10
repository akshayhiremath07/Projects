package com.getitdone.in.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

public class RegisterFilter extends HttpFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String eid_err_msg = "", ename_err_msg = "", eage_err_msg = "", email_err_msg = "", mobile_err_msg = "";

		PrintWriter out = response.getWriter();
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String eage = request.getParameter("eage");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		boolean flag = true;

		if (eid == null || eid.equals("")) {
			eid_err_msg = "Enter the Eid.";
			flag = false;
		}else {
			if(!eid.startsWith("iNeuron-")) {
				eid_err_msg="Id should start with iNeuron-";
				flag=false;
			}else {
				flag=true;
			}
			
		}
		if (ename == null || ename.equals("")) {
			ename_err_msg = "Enter the Ename.";
			flag = false;
		}else {
			if(ename.length()<=3) {
				
				ename_err_msg = "Name length should be more than 3 letters.";
			   flag=false;
			}else {
				flag=true;
			}
		}
		if (eage == null || eage.equals("")) {
			eage_err_msg = "Enter the Eage.";
			flag = false;
		}else {
			if(Integer.parseInt(eage)<20 ||Integer.parseInt(eage)>30) {
			eage_err_msg = "Age must be between 20 and 30.";
			flag=false;
			}else {
				flag=true;
			}
		}
		if (email == null || email.equals("")) {
			email_err_msg = "Enter the Email";
			flag = false;
		}else {
			if(!email.endsWith("@iNeuron.in")) {
				email_err_msg="Email should end with @iNeuron.in.";
				flag=false;
			}else {
				flag=true;
			}
		}
		if (mobile == null || mobile.equals("")) {
			mobile_err_msg = "Enter the Mobile number.";
			flag = false;
		}else {
			if(!mobile.startsWith("91-")) {
				mobile_err_msg="Number should start with 91-.";
				flag=false;
			}else {
				flag=true;
			}
			
		}

		if (flag)
			chain.doFilter(request, response);
		else {
			out.println("<body bgcolor='lightgreen'>");
			out.println("<center>");
			out.println("<h1 style='color:red: text-align:center;font-size:30px;>INeuron AI</h1>");
			out.println("<h2 style='color:blue;text-align:center;'>Employee Registration Form</h2>");
			out.println("<form method='post' action='./reg'>");
			out.println("<table >");
			out.println("<tr><td>Eid</td><td><input type='text'name='eid' value='" + eid + "'/></td><td style='color:red'>"
					+ eid_err_msg + "</td></tr>");
			out.println(
					"<tr><td>Ename</td><td><input type='text' name='ename' value='" + ename + "'/></td><td style='color:red'>" + ename_err_msg + "</td></tr>");
			out.println("<tr><td>Eage</td><td><input type='text' name='eage' value='" + eage + "'/></td><td style='color:red'>" + eage_err_msg + "</td></tr>");
			out.println(
					"<tr><td>Email</td><td><input type='text' name='email' value='" + email + "'/></td><td style='color:red'>" + email_err_msg + "</td></tr>");
			out.println(
					"<tr><td>Mobile</td><td><input type='text' name='mobile' value='" + mobile + "'/></td><td style='color:red'>" + mobile_err_msg + "</td></tr>");
			out.println("<tr><td><input type='submit' value='reg'/></td></tr>");
			out.println("</table>");
			out.println("</form>");
			out.println("</center>");

			out.println("</body>");

		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
