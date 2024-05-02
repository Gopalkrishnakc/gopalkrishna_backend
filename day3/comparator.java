package day3;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
public class comparator {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
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
         Collections.sort(Emplist,(e1,e2)->(e1.getEmpName()).compareTo(e2.getEmpName()));
         Collections.sort(Emplist,(e2,e1)->(e1.getSal()).compareTo(e2.getSal()));
         Collections.sort(Emplist,(e1,e2)->(e1.getEmpId()).compareTo(e2.getEmpId()));
         Emplist.forEach(System.out::println);
   	  sc.close();
	}

}
