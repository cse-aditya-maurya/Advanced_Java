package com.capegemini.relation.BookandPublisherBidirectionalManytoOneMapping;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;

    private String publisherName;
    private String location;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public Publisher() {}

    public Publisher(String publisherName, String location) {
        this.publisherName = publisherName;
        this.location = location;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setPublisher(this);
    }

    public Long getPublisherId() { return publisherId; }
    public List<Book> getBooks() { return books; }

    @Override
    public String toString() {
        return "Publisher{id=" + publisherId +
                ", name='" + publisherName +
                "', location='" + location + "'}";
    }
}
