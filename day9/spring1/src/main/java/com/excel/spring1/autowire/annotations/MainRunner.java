package com.excel.spring1.autowire.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRunner {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/excel/spring1/autowire/annotations/config.xml");
		Employee emp=context.getBean("employee",Employee.class);
		System.out.println(emp);

	}

}
