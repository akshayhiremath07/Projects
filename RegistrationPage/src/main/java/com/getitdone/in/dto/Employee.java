package com.getitdone.in.dto;

public class Employee {
     private String eid=null;
     private String ename=null;
     private Integer age=null;
     private String email=null;
     private String mobile=null;
      
      
	public Employee(String eid, String ename, Integer age, String email, String mobile) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.age = age;
		this.email = email;
		this.mobile = mobile;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", age=" + age + ", email=" + email + ", mobile=" + mobile
				+ "]";
	}
	
      
}
