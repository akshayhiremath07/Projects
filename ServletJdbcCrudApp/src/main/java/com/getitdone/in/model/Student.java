package com.getitdone.in.model;

public class Student {
	private Integer sid;
	String  saddress;
	Integer sage;
    String  sname;
    
	public Student() {
		
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", saddress=" + saddress + ", sage=" + sage + ", sname=" + sname + "]";
	}
  
   
}
