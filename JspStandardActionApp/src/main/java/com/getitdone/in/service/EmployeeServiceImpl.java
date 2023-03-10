package com.getitdone.in.service;

import com.getitdone.in.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public void getSalaryDetails(Employee employee) {
		float grossSalary=employee.getEsalary()+(employee.getEsalary()*0.3f);
		float netSalary=employee.getEsalary()+(employee.getEsalary()* 0.2f);
		
		employee.setGrossSalary(grossSalary);
		employee.setNetSalary(netSalary);
		
	}

}
