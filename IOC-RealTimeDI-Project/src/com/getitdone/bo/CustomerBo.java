package com.getitdone.bo;

public class CustomerBo {
    private String customerName;
    private String customerAddress;
    private float pamt;
    private float rate;
    private float time;
    private float intrAmount;
    
	public CustomerBo() {
		System.out.println("CustomerBo object is instantiated..");
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public float getPamt() {
		return pamt;
	}

	public void setPamt(float pamt) {
		this.pamt = pamt;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public float getIntrAmount() {
		return intrAmount;
	}

	public void setIntrAmount(float intrAmount) {
		this.intrAmount = intrAmount;
	}

	@Override
	public String toString() {
		return "CustomerBo [customerName=" + customerName + ", customerAddress=" + customerAddress + ", pamt=" + pamt
				+ ", rate=" + rate + ", time=" + time + ", intrAmount=" + intrAmount + "]";
	}
	
}
