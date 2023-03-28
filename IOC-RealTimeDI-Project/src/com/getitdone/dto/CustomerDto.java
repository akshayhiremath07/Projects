package com.getitdone.dto;

public class CustomerDto {

	private String customerName;
	private String customerAddress;
	
	private float pamt;
	private float rate;
	private float time;
	private float intrAmount;
	static {
		System.out.println("CustomerDto.class file is loading...");
		
	}
	public CustomerDto(){
		System.out.println("CustomerDto object instantiated..");
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public void setPamt(float pamt) {
		this.pamt = pamt;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public void setTime(float time) {
		this.time = time;
	}
	public void setIntrAmount(float intrAmount) {
		this.intrAmount = intrAmount;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public float getPamt() {
		return pamt;
	}
	public float getRate() {
		return rate;
	}
	public float getTime() {
		return time;
	}
	public float getIntrAmount() {
		return intrAmount;
	}
	@Override
	public String toString() {
		return "CustomerDto [customerName=" + customerName + ", customerAddress=" + customerAddress + ", pamt=" + pamt
				+ ", rate=" + rate + ", time=" + time + ", intrAmount=" + intrAmount + "]";
	}
	
	
	
	
}
