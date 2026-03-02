package com.pageturner.bookstore.service;

import com.pageturner.bookstore.entity.Book;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    List<Book> getBooksByAuthor(String author);

    Page<Book> getBooksByGenre(String genre, int page, int size);

    List<Book> getBooksCheaperThan(Double maxPrice);

    List<Book> getBooksMoreExpensiveThan(Double minPrice);

    List<Book> getBooksPublishedAfter(LocalDate date);

    List<Book> searchBooksByTitleKeyword(String keyword);

    List<Book> getBooksByGenreAndAuthor(String genre, String author);

    List<Book> getBooksByGenreOrAuthor(String genre, String author);

    List<Book> getBooksByPriceRange(Double minPrice, Double maxPrice);

    List<Book> getBooksByGenreBelowPrice(String genre, Double maxPrice);

    Page<Book> getLatestBooks(int page, int size);

    Page<Book> getBooksByPriceAscending(int page, int size);
}