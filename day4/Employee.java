package day4;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Employee {
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

	@Override
	public String toString() {
		return this.empId + " " + this.empName + " " + this.sal;
	}

	public int hashCode() {
		return this.empId;
	}

	public boolean equals(Object e) {
		Employee emp = (Employee) e;
		return this.hashCode() == emp.hashCode();
	}

	public Employee(Integer empId, String empName, Double sal) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.sal = sal;
	}

	public Employee() {
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Employee> hs=new HashSet<>();
		while(true) {
			System.out.println("Enter empId");
			int empId=sc.nextInt();
			System.out.println("Enter empName");
			String empName=sc.next();
			System.out.println("Enter sal");
			double sal=sc.nextDouble();
			hs.add(new Employee(empId,empName,sal));
			System.out.println("Need add another record");
			String response=sc.next();
			if(response.equalsIgnoreCase("no")) {
				break;
			}
		}
		sc.close();
		for(Employee em:hs) {
			System.out.println(em);
		}
	}
}
