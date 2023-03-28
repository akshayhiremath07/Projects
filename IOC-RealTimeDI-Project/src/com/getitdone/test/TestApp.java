package com.getitdone.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.getitdone.main.MainController;
import com.getitdone.vo.CustomerVo;

public class TestApp {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the customer name___");
		String customerName = scanner.next();
		System.out.print("Enter the customer Address___");
		String customerAddress = scanner.next();
		System.out.print("Enter the Principle amount___");
		String pamt = scanner.next();
		System.out.print("Enter the Rate of intrest___");
		String rate = scanner.next();
		System.out.print("Enter the time period___");
		String time = scanner.next();
		
		CustomerVo customerVo = new CustomerVo();
		customerVo.setCustomerName(customerName);
		customerVo.setCustomerAddress(customerAddress);
		customerVo.setPamt(pamt);
		customerVo.setRate(rate);
		customerVo.setTime(time);
		
	  
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/getitdone/cfg/applicationContext.xml");
		System.out.println("****Container Started****");
		System.out.println();
		MainController controller = factory.getBean("main",MainController.class);
		System.out.println(controller);
		try {
			String result = controller.processCustomer(customerVo);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Internal problem...try again"+e.getMessage());
		}
		
		System.out.println();
		System.out.println("****Container Stopped****");
		
		scanner.close();
	}

}
