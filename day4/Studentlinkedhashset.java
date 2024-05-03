package day4;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Studentlinkedhashset {
	
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

		public Studentlinkedhashset(int stuId, String stuName, int marks,int age) {
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
		Studentlinkedhashset std=(Studentlinkedhashset)o;
		return this.hashCode()==std.hashCode()&& this.marks==std.marks &&this.stuId==std.stuId;
	}
		public static void main(String[] args) {
			Set<Studentlinkedhashset>hs=new LinkedHashSet<>();
			Scanner sc=new Scanner(System.in);
			while(true) {
				System.out.println("enter student id");
				int stuId=sc.nextInt();
			
			System.out.println("enter student age");
			int age=sc.nextInt();
			System.out.println("enter student marks");
			int marks=sc.nextInt();
			System.out.println("enter student name");
			String stuName=sc.next();
			hs.add(new Studentlinkedhashset(stuId,stuName,marks,age));
			System.out.println("need to add another");
			String response=sc.next();
			if(response.equalsIgnoreCase("no")) {
				break;
			}
		}
			
			sc.close();
			for(Studentlinkedhashset s:hs) {
				System.out.println(s);
			}
			}
		}

