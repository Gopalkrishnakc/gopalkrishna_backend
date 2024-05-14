package com.excel.springhibernate1;

import java.util.List;

public interface StudentDao {
public int insertStudent(Student student);
public Student updateStudent(Student student);
Student getStudent(int id);
Student deleteStudent(int id);
public List<Student>getAllStudents();
}
