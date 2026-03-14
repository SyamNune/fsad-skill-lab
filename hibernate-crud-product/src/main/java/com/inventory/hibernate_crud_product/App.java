package com.inventory.hibernate_crud_product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();

        Product deleteProduct = session.get(Product.class, 1);

        if(deleteProduct != null) {
            session.remove(deleteProduct);
        }

        session.getTransaction().commit();

        System.out.println("Product deleted successfully");
    }
}