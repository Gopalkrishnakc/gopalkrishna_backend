package com.excel.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      ApplicationContext context=new ClassPathXmlApplicationContext("com/excel/spring1/config.xml");
      Student student1=(Student)context.getBean("student");
      Student student2=(Student)context.getBean("student1");
      System.out.println(student1);
      System.out.println(student2);
    }
}
