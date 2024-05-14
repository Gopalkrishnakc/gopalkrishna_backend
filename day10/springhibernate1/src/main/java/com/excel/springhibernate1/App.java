package com.excel.springhibernate1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ){
    
       ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
     StudentDao dao=context.getBean("studentDao",StudentDao.class);
     Student student=new Student();
     student.setStudent_id(1);
//     student.setStudent_name("ullas");
//     student.setStudent_city("Hassan");
//  int res=dao.insertStudent(student);
//     System.out.println(res);
//     Student update=dao.updateStudent(student);
//     System.out.println(update);
//   Student get=dao.getStudent(1);
//   System.out.println(get);
//     Student delete=dao.deleteStudent(1);
     
}
}