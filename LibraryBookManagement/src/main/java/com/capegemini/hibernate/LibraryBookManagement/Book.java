package com.capegemini.hibernate.LibraryBookManagement;

import jakarta.persistence.*;

@Entity
@Table(name = "library_books")
public class Book {

    @Id
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author_name", nullable = false)
    private String authorName;

    @Column(name = "genre")
    private String genre;

    @Column(name = "price")
    private double price;

    @Column(name = "availability_status")
    private String availabilityStatus;

    @Column(name = "published_year")
    private int publishedYear;

    public Book() {}

    public Book(int bookId, String title, String authorName,
                String genre, double price,
                String availabilityStatus, int publishedYear) {
        this.bookId = bookId;
        this.title = title;
        this.authorName = authorName;
        this.genre = genre;
        this.price = price;
        this.availabilityStatus = availabilityStatus;
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return bookId + " | " + title + " | " + authorName +
                " | " + genre + " | " + price +
                " | " + availabilityStatus +
                " | " + publishedYear;
    }

    // getters & setters (important for JPA)

    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getAvailabilityStatus() { return availabilityStatus; }
    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public int getPublishedYear() { return publishedYear; }
    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
}
