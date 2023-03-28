package com.getitdone.vo;

public class CustomerVo {
   private String customerName;
   private String customerAddress;
   private String pamt;
   private String rate;
   private String time;
   static {
		System.out.println("CustomerVo.class file is loading...");
		
	}
	public CustomerVo(){
		System.out.println("CustomerVo object instantiated..");
	}
	


public String getCustomerName() {
	return customerName;
}

public String getCustomerAddress() {
	return customerAddress;
}


public void setCustomerName(String customerName) {
	this.customerName = customerName;
}



public void setCustomerAddress(String customerAddress) {
	this.customerAddress = customerAddress;
}



public void setPamt(String pamt) {
	this.pamt = pamt;
}



public void setRate(String rate) {
	this.rate = rate;
}



public void setTime(String time) {
	this.time = time;
}



public String getPamt() {
	return pamt;
}

public String getRate() {
	return rate;
}

public String getTime() {
	return time;
}

@Override
public String toString() {
	return "CustomerVo [customerName=" + customerName + ", customerAddress=" + customerAddress + ", pamt=" + pamt
			+ ", rate=" + rate + ", time=" + time + "]";
}
   
}
