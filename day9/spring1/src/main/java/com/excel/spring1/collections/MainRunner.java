package com.excel.spring1.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRunner {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/excel/spring1/collections/config.xml");
Employee emp=(Employee)context.getBean("employee");
System.out.println(emp.getName());
System.out.println(emp.getPhone());
System.out.println(emp.getSkills());
System.out.println(emp.getNominees());
	}

}
