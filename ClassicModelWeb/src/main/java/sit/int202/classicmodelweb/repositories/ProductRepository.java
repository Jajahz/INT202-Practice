package sit.int202.classicmodelweb.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classicmodelweb.entities.Product;
import sit.int202.classicmodelweb.services.EntityManagerService;

import java.util.List;

public class ProductRepository {
    private static final int PAGE_SIZE = 10;

    private EntityManager getEntityManager() {
        return EntityManagerService.getEntityManager();
    }
    
    public List<Product> findAll(int... pageInfos) {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("Product.FindAll");
        query.setFirstResult(pageInfos.length > 0 ? pageInfos[0] : 0);
        query.setMaxResults(pageInfos.length > 1 ? pageInfos[1] : PAGE_SIZE);
        List<Product> productList = query.getResultList();
        entityManager.close();
        return productList;
    }

    public int countAll() {
        EntityManager entityManager = getEntityManager();
        int number = ((Number) entityManager.createNamedQuery("Product.count").getSingleResult()).intValue();
        entityManager.close();
        return number;
    }

    public Product find(String productCode){
        EntityManager entityManager = getEntityManager();
        Product product = entityManager.find(Product.class, productCode);
        entityManager.close();
        return product;
    }
}
