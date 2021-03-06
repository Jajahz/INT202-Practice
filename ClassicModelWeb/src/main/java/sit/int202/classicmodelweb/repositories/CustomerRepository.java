package sit.int202.classicmodelweb.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classicmodelweb.entities.Customer;
import sit.int202.classicmodelweb.entities.Office;
import sit.int202.classicmodelweb.services.EntityManagerService;

import java.util.List;

public class CustomerRepository {
    private static final String FIND_USER = "SELECT c FROM Customer c";

    private EntityManager getEntityManager() {
        return EntityManagerService.getEntityManager();
    }

    public Customer findByName(String name) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("FIND_USER");
        query.setParameter("user_account", name);
        List<Customer> customers = query.getResultList();
        em.close();
        return customers.size()==0? null : customers.get(0);
    }

    public List<Customer> findAll(){
        EntityManager entityManager = getEntityManager();
        List<Customer> customerList = entityManager.createQuery(FIND_USER).getResultList();
        entityManager.close();
        return customerList;
    }
}