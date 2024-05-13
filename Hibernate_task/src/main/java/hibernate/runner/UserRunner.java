package hibernate.runner;

import hibernate.entity.UserTable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserRunner {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("student");
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        UserTable user=new  UserTable();
        et.begin();
        et.commit();
        
	}

}
