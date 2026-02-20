package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("my-persistence-unit");

        EntityManager em = emf.createEntityManager();

        try {

            User user = new User();
            user.setUsername("John");

            Set<String> emails = new HashSet<>();
            emails.add("john@gmail.com");
            emails.add("john.work@gmail.com");
            emails.add("john@gmail.com");

            user.setEmails(emails);

            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();

            System.out.println("User saved successfully!");

            User fetchedUser = em.find(User.class, user.getUserId());

            System.out.println("User Name: " + fetchedUser.getUsername());
            System.out.println("Emails: " + fetchedUser.getEmails());

        } finally {
            em.close();
            emf.close();
        }
    }
}
