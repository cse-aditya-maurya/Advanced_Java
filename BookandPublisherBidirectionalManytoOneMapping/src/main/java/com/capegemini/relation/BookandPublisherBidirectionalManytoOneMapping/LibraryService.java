package com.capegemini.relation.BookandPublisherBidirectionalManytoOneMapping;

import jakarta.persistence.*;

public class LibraryService {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("libraryPU");

    public void createPublisherWithBooks() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Publisher publisher = new Publisher("TechBooks", "New York");

        Book b1 = new Book("Hibernate Guide", 500);
        Book b2 = new Book("Spring Boot Mastery", 650);

        publisher.addBook(b1);
        publisher.addBook(b2);

        em.persist(publisher);

        em.getTransaction().commit();
        em.close();
    }

    public void fetchPublisher(Long id) {
        EntityManager em = emf.createEntityManager();

        Publisher p = em.find(Publisher.class, id);

        System.out.println("Publisher: " + p);
        System.out.println("Books:");
        p.getBooks().forEach(System.out::println);

        em.close();
    }

    public void fetchBook(Long id) {
        EntityManager em = emf.createEntityManager();

        Book b = em.find(Book.class, id);

        System.out.println("Book: " + b);
        System.out.println("Publisher: " + b.getPublisher());

        em.close();
    }

    public void close() {
        emf.close();
    }
}
