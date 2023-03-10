package com.getitdone.in.dto;

public class Employee {
   private String ename;
   private String eaddress;
   private Integer esalary;
   private float grossSalary;
   private float netSalary;
   
   public Employee() {
	   
   }

public String getEname() {
	return ename;
}

public void setEname(String ename) {
	this.ename = ename;
}

public String getEaddress() {
	return eaddress;
}

public void setEaddress(String eaddress) {
	this.eaddress = eaddress;
}

public Integer getEsalary() {
	return esalary;
}

public void setEsalary(Integer esalary) {
	this.esalary = esalary;
}

public float getGrossSalary() {
	return grossSalary;
}

public void setGrossSalary(float grossSalary) {
	this.grossSalary = grossSalary;
}

public float getNetSalary() {
	return netSalary;
}

public void setNetSalary(float netSalary) {
	this.netSalary = netSalary;
}

@Override
public String toString() {
	return "Employee [ename=" + ename + ", eaddress=" + eaddress + ", esalary=" + esalary + ", grossSalary="
			+ grossSalary + ", netSalary=" + netSalary + "]";
}
   
}
