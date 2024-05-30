package com.excel.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component("studentDao")
public class StudentDaoImplem implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertStudent(Student student) {
		String query="insert into Student(id,name,marks) values(?,?,?)" ;
		return jdbcTemplate.update(query,student.getId(),student.getName(),student.getMarks());
	}

	@Override
	public int updateStudent(Student student) {
	String query="update student set id=?, name=?,marks=?";
		return jdbcTemplate.update(query,student.getId(),student.getName(),student.getMarks() );
	}

	@Override
	public int deleteStudent(Student student) {
		String query="delete from student where id=?";
		return jdbcTemplate.update(query,student.getId());
	}
	
}
