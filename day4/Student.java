package day4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Student {
	private Integer stuId;
	private String stuName;
	private Integer marks;

private Integer age;
	public Integer getAge() {
	return age;
}



public void setAge(Integer age) {
	this.age = age;
}

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Student(int stuId, String stuName, int marks,int age) {
		this.marks = marks;
		this.stuId = stuId;
		this.stuName = stuName;
		this.age=age;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", marks=" + marks + ", age=" + age + "]";
	}

	public int hashCode() {
		return this.age;
	}
public boolean equals(Object o) {
	Student std=(Student)o;
	return this.hashCode()==std.hashCode()&& this.marks==std.marks &&this.stuId==std.stuId;
}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Set<Student> hss1=new HashSet<>();
		while(true) {
			System.out.println("enter student id");
			int stuId=sc.nextInt();
		
		System.out.println("enter student age");
		int age=sc.nextInt();
		System.out.println("enter student marks");
		int marks=sc.nextInt();
		System.out.println("enter student name");
		String stuName=sc.next();
		hss1.add(new Student(stuId,stuName,marks,age));
		System.out.println("need to add another");
		String response=sc.next();
		if(response.equalsIgnoreCase("no")) {
			break;
		}
	}
		sc.close();
		for(Student s:hss1) {
			System.out.println(s);
		}
	}
}
