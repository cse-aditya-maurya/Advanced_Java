package com.capegemini.relation.BookandPublisherBidirectionalManytoOneMapping;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String title;
    private double price;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Book() {}

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getBookId() { return bookId; }
    public Publisher getPublisher() { return publisher; }

    @Override
    public String toString() {
        return "Book{id=" + bookId +
                ", title='" + title +
                "', price=" + price + "}";
    }
}
