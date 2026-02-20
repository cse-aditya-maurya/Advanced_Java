package com.capegemini.hibernate.LibraryBookManagement;

import jakarta.persistence.*;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("libraryPU");
        EntityManager em = emf.createEntityManager();

        // CREATE
        em.getTransaction().begin();

        Book b1 = new Book(1, "Java Basics", "James Gosling",
                "Programming", 450, "Available", 2020);

        Book b2 = new Book(2, "Hibernate Guide", "Gavin King",
                "Technology", 550, "Available", 2022);

        Book b3 = new Book(3, "Spring Boot", "Rod Johnson",
                "Framework", 650, "Issued", 2023);

        em.persist(b1);
        em.persist(b2);
        em.persist(b3);

        em.getTransaction().commit();

        // READ by ID
        System.out.println("\nFetch by ID:");
        Book book = em.find(Book.class, 1);
        System.out.println(book);

        // READ all
        System.out.println("\nAll Books:");
        List<Book> books =
                em.createQuery("from Book", Book.class)
                        .getResultList();
        books.forEach(System.out::println);

        // UPDATE
        em.getTransaction().begin();

        Book updateBook = em.find(Book.class, 2);
        updateBook.setPrice(600);
        updateBook.setAvailabilityStatus("Issued");

        em.getTransaction().commit();

        System.out.println("\nAfter Update:");
        System.out.println(updateBook);

        // DELETE
        em.getTransaction().begin();

        Book deleteBook = em.find(Book.class, 3);
        em.remove(deleteBook);

        em.getTransaction().commit();

        System.out.println("\nAfter Delete:");
        List<Book> remaining =
                em.createQuery("from Book", Book.class)
                        .getResultList();
        remaining.forEach(System.out::println);

        em.close();
        emf.close();
    }
}
