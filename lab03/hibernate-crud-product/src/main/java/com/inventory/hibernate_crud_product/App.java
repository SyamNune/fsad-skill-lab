package com.inventory.hibernate_crud_product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class App {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();
        Query<Product> startQuery = session.createQuery(
                "FROM Product WHERE name LIKE 'M%'", Product.class);

        List<Product> startList = startQuery.getResultList();
        System.out.println("Names starting with M:");
        for(Product p : startList){
            System.out.println(p.getName());
        }
        Query<Product> endQuery = session.createQuery(
                "FROM Product WHERE name LIKE '%e'", Product.class);

        List<Product> endList = endQuery.getResultList();
        System.out.println("\nNames ending with e:");
        for(Product p : endList){
            System.out.println(p.getName());
        }
        Query<Product> containQuery = session.createQuery(
                "FROM Product WHERE name LIKE '%top%'", Product.class);

        List<Product> containList = containQuery.getResultList();
        System.out.println("\nNames containing 'top':");
        for(Product p : containList){
            System.out.println(p.getName());
        }
        Query<Product> lengthQuery = session.createQuery(
                "FROM Product WHERE length(name) = 6", Product.class);

        List<Product> lengthList = lengthQuery.getResultList();
        System.out.println("\nNames with 6 characters:");
        for(Product p : lengthList){
            System.out.println(p.getName());
        }

        session.getTransaction().commit();

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}