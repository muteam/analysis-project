package com.muteam.analysis.project.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

import com.muteam.analysis.project.dao.*;
import com.muteam.analysis.project.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> list() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> productList = (List<Product>) session.createCriteria(Product.class).list();
        transaction.commit();
        session.close();
        return productList;
    }

    @Override
    public Product getById(String id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = (Product) session.get(Product.class, id);
        transaction.commit();
        session.close();
        return product;
    }

    @Override
    public void save(Product product) {
        product.setId(UUID.randomUUID().toString());
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(product);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
    }

    @Override
    public void delete(String id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = (Product) session.load(Product.class, id);
        session.delete(product);
        transaction.commit();
        session.flush();
        session.close();
    }
}
