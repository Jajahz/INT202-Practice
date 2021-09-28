package sit.int202.classicmodelweb;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

    public class Main {
        public static void main(String[] args) {
            EntityManagerFactory emf =  Persistence.createEntityManagerFactory("default");
            EntityManager em = emf.createEntityManager();
            Office office = em.find(Office.class, "1");
            System.out.println(office);
        }
    }