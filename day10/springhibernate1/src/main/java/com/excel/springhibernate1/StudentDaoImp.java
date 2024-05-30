package com.excel.springhibernate1;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component("studentDao")
public class StudentDaoImp implements StudentDao{
	@Autowired
	HibernateTemplate hibernateTemplate;

	
	
	@Transactional
	@Override
	public int insertStudent(Student student) {
		
		String query="insert into springhibernate(student_id,student_name,student_city) values(?,?,?)";
		return (int) hibernateTemplate.save(student);
	}


	@Transactional
	
	public Student updateStudent(Student student) {
	   hibernateTemplate.saveOrUpdate(student);
		return student;
	}

	@Transactional
	@Override
	public Student getStudent(int id) {
		Student student=this.hibernateTemplate.get(Student.class,id);
		return student;
	}

   @Transactional
	public Student deleteStudent(int id) {
		Student student=this.hibernateTemplate.get(Student.class,id);
		this.hibernateTemplate.delete(student);
		return student;
	}


@Override
public List<Student> getAllStudents() {
	// TODO Auto-generated method stub
	return null;
}



 
	
		
	
	

}
