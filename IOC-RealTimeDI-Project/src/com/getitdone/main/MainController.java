package com.getitdone.main;

import com.getitdone.dto.CustomerDto;
import com.getitdone.service.ICustomerService;
import com.getitdone.vo.CustomerVo;

public class MainController {
   private ICustomerService service;

	public MainController(ICustomerService service) {
	this.service = service;
	System.out.println("MainController.MainController()---->"+service.getClass().getName());
}

	public String processCustomer(CustomerVo vo)throws Exception{
		
		CustomerDto customerDTO = new CustomerDto();
		customerDTO.setCustomerAddress(vo.getCustomerAddress());
		customerDTO.setCustomerName(vo.getCustomerName());
		customerDTO.setPamt(Float.parseFloat(vo.getPamt()));
		customerDTO.setRate(Float.parseFloat(vo.getRate()));
		customerDTO.setTime(Float.parseFloat(vo.getTime()));
		String result = service.calculateSimpleInterest(customerDTO);
		return result;
	}

	@Override
	public String toString() {
		return "MainController [service=" + service + "]";
	}

	
}
