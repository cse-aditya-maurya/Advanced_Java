package com.capegemini.hibernates.ConnectDB;

/**
 * Hello world!
 *
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Load Configuration and Create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        // Open a session
        Session session = factory.openSession();

        try {
            session.beginTransaction();

            // CREATE (INSERT)
            Customer newCustomer = new Customer(106, "Alice Johnson", "Chicago");
            session.persist(newCustomer); 

            // READ (FIND)
            Customer foundCustomer = session.find(Customer.class, 103);
            System.out.println("Found Customer: " + foundCustomer);

            // UPDATE
            if (foundCustomer != null) {
                foundCustomer.setName("Alice Updated");
                foundCustomer.setCity("Seattle");
                session.merge(foundCustomer); 
                System.out.println("Updated Customer: " + foundCustomer);
            }

            // DELETE
            Customer customerToDelete = session.find(Customer.class, 101);
            if (customerToDelete != null) {
                session.remove(customerToDelete); 
                System.out.println("Deleted Customer: " + customerToDelete);
            }

            // Commit Transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
            factory.close();
        }
    }
}
