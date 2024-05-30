package com.excel.spring1.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRunner {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/excel/spring1/constructor/config.xml");
      Employee emp=(Employee)context.getBean("employee");
      System.out.println(emp);
	}

}
