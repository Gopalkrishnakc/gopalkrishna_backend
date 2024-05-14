package hibernate.runner;


import hibernate.entity.InventoryTable;
import hibernate.entity.StockMovement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StockMovementRunner {

	
		public static void main(String[] args) {
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("student");
	        EntityManager em=emf.createEntityManager();
	        EntityTransaction et=em.getTransaction();
	        InventoryTable it=new InventoryTable();
	        StockMovement  sm=new StockMovement();
	        et.begin();
	        et.commit();
	        

	}

}
