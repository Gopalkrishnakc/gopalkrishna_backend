package manytomany.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import manytomany.Book;
import manytomany.Student3;

public class MainRunner3 {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("student");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		List<Book>books=new ArrayList<Book>();
		
		Book b1=new Book();
		Book b2=new Book();
		Book b3=new Book();
		
		b1.setBookName("the word");
		b2.setBookName("Garden");
		b2.setBookName("Pink city");
		List<Student3>students=new ArrayList<Student3>();
		
		Student3 s1=new Student3();
		Student3 s2=new Student3();
		Student3 s3=new Student3();
		
		s1.setStuName("gopal");
		s1.setBooks(books);
		s2.setStuName("ullas");
		s2.setBooks(books);
		s3.setStuName("varun");
		s3.setBooks(books);
		
		b1.setStudents(students);
		b2.setStudents(students);
		b3.setStudents(students);
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		books.add(b1);
		books.add(b2);
		books.add(b3);
		et.begin();
		em.persist(books);
		em.persist(students);
		et.commit();
	}

}
