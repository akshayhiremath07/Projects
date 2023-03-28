package com.getitdone.service;

import com.getitdone.bo.CustomerBo;
import com.getitdone.dao.ICustomerDao;
import com.getitdone.dto.CustomerDto;

public class CustomerServiceImpl implements ICustomerService {
 
	private ICustomerDao dao;
	
	public CustomerServiceImpl(ICustomerDao dao) {
		this.dao = dao;
		System.out.println("CustomerServiceImpl.CustomerServiceImpl()---->"+dao.getClass().getName());
	}

	@Override
	public String calculateSimpleInterest(CustomerDto dto) {
		float intrAmount=(dto.getPamt()*dto.getRate()*dto.getTime())/100.0f;
		
		CustomerBo bo=new CustomerBo();
		bo.setCustomerAddress(dto.getCustomerAddress());
		bo.setCustomerName(dto.getCustomerName());
        bo.setPamt(dto.getPamt());
        bo.setRate(dto.getRate());
        bo.setTime(dto.getTime());
        bo.setIntrAmount(intrAmount);
        String result = null;
        try {
			result = dao.save(bo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result=="success"?"customer registration successful..-----Simple Intrest is ::"+intrAmount:"customer Registration failed..";
	}

	@Override
	public String toString() {
		return "CustomerServiceImpl [dao=" + dao + "]";
	}

}
