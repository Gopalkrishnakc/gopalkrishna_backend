package onetoone.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import onetoone.entity.MarksCard;
import onetoone.entity.Student;

public class MainRUnner {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("student");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		MarksCard card=new MarksCard();
		card.setGrade("A");
		card.setMarks(91);
		Student st=new Student();
		st.setStuName("ullas");
		st.setAge(22);
		st.setMarkscard(card);
		card.setStudent(st);
		et.begin();
		em.persist(st);
		em.persist(card);
		et.commit();
        em.close();
	}

}
