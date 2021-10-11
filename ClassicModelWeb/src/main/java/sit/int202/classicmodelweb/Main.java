package sit.int202.classicmodelweb;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import sit.int202.classicmodelweb.entities.Office;

public class Main {
        public static void main(String[] args) {
            EntityManagerFactory emf =  Persistence.createEntityManagerFactory("default");
            EntityManager em = emf.createEntityManager();
            Office office = em.find(Office.class, "2");
            System.out.println(office.getId() + " : " + office.getCity());
            System.out.println("----------------------------------------");
            office.getEmployeeList().forEach(e -> {
                System.out.printf("%5d %-9s %-15s %s\n",
                        e.getId(), e.getFirstName(), e.getLastName(), e.getEmail());
            });
            em.close();
        }
    }