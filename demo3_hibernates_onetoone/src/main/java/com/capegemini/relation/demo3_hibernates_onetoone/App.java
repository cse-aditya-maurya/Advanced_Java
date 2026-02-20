package com.capegemini.relation.demo3_hibernates_onetoone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	   EntityManagerFactory emf =
                   Persistence.createEntityManagerFactory("myPersistenceUnit");
           EntityManager em = emf.createEntityManager();

           // CREATE
           em.getTransaction().begin();
           
           Account account=new Account("ACC1234","Saving");
           Customer customer=new Customer("John Doe",account);
           account.setCustomer(customer);
           em.persist(customer);
           em.getTransaction().commit();
           System.out.println("Customer and Account Saved Successfully");
           
           
           
           
    }
}
