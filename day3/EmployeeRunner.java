package day3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class EmployeeRunner {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		Employee emp=new Employee();
	  LinkedList<Employee> Emplist=new LinkedList<>();
	  while(true) {
		  System.out.println("Enter empId");
		  Integer empId=sc.nextInt();
		  System.out.println("Enter empName");
		  String empName=sc.next();
		  System.out.println("Enter sal");
		  Double sal=sc.nextDouble();
		  Emplist.add(new Employee(empId,empName,sal));
		  System.out.println("Do you want to add another object of Employee");
		  if(!sc.next().equalsIgnoreCase("yes")) {
			  break;
		  }
		  }
	  
	  Collections.sort(Emplist);
	  Emplist.forEach(System.out::println);
	  
	}

	

}
