package com.excel.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao dao=context.getBean("studentDao",StudentDao.class);
        //insert
        Student student=new Student();
        student.setId(1);
        student.setName("gopal");
        student.setMarks(65);
        int res=dao.insertStudent(student);
        System.out.println(res);
        
        //update
//        int status=dao.updateStudent(new Student(1,"Sonoo",98)); 
//        System.out.println(status);
        
        //delete
//        Student student=new Student();
//      student.setId(1);
//        int res=dao.deleteStudent(student);
//     System.out.println(res);
    }
}
