package onetomanyservice;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import onetomany.Laptop;
import onetomany.Student1;

public class MainRunner {

	public static void main(String[] args, List<Laptop> laptops) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("student");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
     List<Laptop>latops=new ArrayList<Laptop>();
     Student1 st=new Student1();
     Laptop lap=new Laptop();
     lap.setBrand("Dell");
    lap.setSerialNum("ASF12F6G");
    lap.setStudent(st);
    
    Laptop lap1=new Laptop();
    lap1.setBrand("lenovo");
   lap1.setSerialNum("ADF16F6G");
   lap1.setStudent(st);
   
   Laptop lap2=new Laptop();
   lap2.setBrand("hp");
  lap2.setSerialNum("CDF16F6G");
  lap2.setStudent(st);
  
   latops.add(lap1);
   latops.add(lap);
   laptops.add(lap2);

   st.setStuName("gopal");
   st.setAge(22);
  st.setLaptops(laptops);
   et.begin();
   em.persist(st);
 
   et.commit();
	}

}
