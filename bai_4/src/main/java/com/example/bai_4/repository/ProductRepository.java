package com.example.bai_4.repository;

import com.example.bai_4.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    private static final String SELECT_ALL_PRODUCTS_QUERY = "FROM Product";

    @Override
    public List<Product> display() {
        List<Product> productList = ConnectionUtils.getEntityManager().createQuery(SELECT_ALL_PRODUCTS_QUERY).getResultList();
        return productList;
    }


    @Override
    public void create(Product product) {
        Session session = null;
        Transaction transactional = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transactional = session.beginTransaction();
            session.save(product);
            transactional.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transactional != null) {
                transactional.rollback();
            }
        } finally {
            if (session != null) {
                session.clear();
            }
        }
    }

    @Override
    public Product showProductUpdate(int id) {
        Product product = null;
        List<Product> productList = display();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                product = productList.get(i);
                break;
            }
        }
        return product;
    }

    @Override
    public boolean update(Product product) {
        boolean flag = false;
        List<Product> productList = display();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.set(i, product);
                flag = true;
                break;
            }
        }
        if (flag) {
            EntityManager entityManager = ConnectionUtils.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        List<Product> productList = display();
        Product product = null;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                product = productList.get(i);
                productList.remove(i);
                flag = true;
                break;
            }
        }
        if (flag) {
            EntityManager entityManager = ConnectionUtils.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(product);
            entityManager.getTransaction().commit();
        }
        return flag;
    }

    @Override
    public Product detail(int id) {
        Product product = null;
        List<Product> productList = display();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                product = display().get(i);
                break;
            }
        }
        return product;
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> productList = display();
        List<Product> productList1 = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (display().get(i).getName().contains(name)) {
                productList1.add(display().get(i));
            }
        }
        return productList1;
    }
}
