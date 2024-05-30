package day4;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;



public class TreesetDemo {
	private Integer empId;
	private String empName;
	private Double sal;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}
	public  TreesetDemo(Integer empId, String empName, Double sal) {
		
		this.empId = empId;
		this.empName = empName;
		this.sal = sal;
	}

	@Override
	public String toString() {
		return this.empId + " " + this.empName + " " + this.sal;
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Set<TreesetDemo> ts=new TreeSet<>((e1,e2)->e1.getEmpId()-e2.getEmpId());
	 while(true) {
		  System.out.println("Enter empId");
		  Integer empId=sc.nextInt();
		  System.out.println("Enter empName");
		  String empName=sc.next();
		  System.out.println("Enter sal");
		  Double sal=sc.nextDouble();
		  ts.add(new TreesetDemo(empId,empName,sal));
		  System.out.println("Do you want to add another object of Employee");
		  if(!sc.next().equalsIgnoreCase("yes")) {
			  break;
		  }
		  }	
	 sc.close();
	 for(TreesetDemo t:ts ) {
		 System.out.println(t);
	 }
}
}
