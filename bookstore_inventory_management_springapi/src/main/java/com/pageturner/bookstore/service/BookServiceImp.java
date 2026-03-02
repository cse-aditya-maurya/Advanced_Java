package com.pageturner.bookstore.service;

import com.pageturner.bookstore.entity.Book;
import com.pageturner.bookstore.exception.ResourceNotFoundException;
import com.pageturner.bookstore.exception.InvalidParameterException;
import com.pageturner.bookstore.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 1. Books by Author
    @Override
    public List<Book> getBooksByAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new InvalidParameterException("Author must not be empty");
        }

        List<Book> books = bookRepository.findByAuthor(author);

        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No books found for author: " + author);
        }

        return books;
    }

    // 2. Books by Genre (Paginated)
    @Override
    public Page<Book> getBooksByGenre(String genre, int page, int size) {

        validatePageAndSize(page, size);

        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books = bookRepository.findByGenre(genre, pageable);

        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No books found for genre: " + genre);
        }

        return books;
    }

    // 3. Cheaper Books
    @Override
    public List<Book> getBooksCheaperThan(Double maxPrice) {
        validatePrice(maxPrice);

        List<Book> books = bookRepository.findByPriceLessThan(maxPrice);

        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No books found cheaper than: " + maxPrice);
        }

        return books;
    }

    // 4. Expensive Books
    @Override
    public List<Book> getBooksMoreExpensiveThan(Double minPrice) {
        validatePrice(minPrice);

        List<Book> books = bookRepository.findByPriceGreaterThan(minPrice);

        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No books found above: " + minPrice);
        }

        return books;
    }

    // 5. Published After Date
    @Override
    public List<Book> getBooksPublishedAfter(LocalDate date) {

        if (date == null) {
            throw new InvalidParameterException("Published date must not be null");
        }

        List<Book> books = bookRepository.findByPublishedDateAfter(date);

        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No books found after: " + date);
        }

        return books;
    }

    // 6. Search by Title
    @Override
    public List<Book> searchBooksByTitleKeyword(String keyword) {

        if (keyword == null || keyword.isBlank()) {
            throw new InvalidParameterException("Keyword must not be empty");
        }

        List<Book> books = bookRepository.findByTitleContaining(keyword);

        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No books found for keyword: " + keyword);
        }

        return books;
    }

    // 7. Genre AND Author
    @Override
    public List<Book> getBooksByGenreAndAuthor(String genre, String author) {

        List<Book> books = bookRepository.findByGenreAndAuthor(genre, author);

        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No books found for given genre and author");
        }

        return books;
    }

    // 8. Genre OR Author
    @Override
    public List<Book> getBooksByGenreOrAuthor(String genre, String author) {

        List<Book> books = bookRepository.findByGenreOrAuthor(genre, author);

        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No books found for given genre or author");
        }

        return books;
    }

    // 9. Price Range
    @Override
    public List<Book> getBooksByPriceRange(Double minPrice, Double maxPrice) {

        validatePrice(minPrice);
        validatePrice(maxPrice);

        if (minPrice > maxPrice) {
            throw new InvalidParameterException("Min price cannot be greater than max price");
        }

        List<Book> books = bookRepository.findByPriceBetween(minPrice, maxPrice);

        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No books found in given price range");
        }

        return books;
    }

    // 10. Genre below price
    @Override
    public List<Book> getBooksByGenreBelowPrice(String genre, Double maxPrice) {

        validatePrice(maxPrice);

        List<Book> books = bookRepository.findByGenreAndPriceLessThan(genre, maxPrice);

        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No discounted books found for genre");
        }

        return books;
    }

    // 11. Latest Books (Sorted by Published Date Desc)
    @Override
    public Page<Book> getLatestBooks(int page, int size) {

        validatePageAndSize(page, size);

        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books = bookRepository.findByOrderByPublishedDateDesc(pageable);

        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No books found");
        }

        return books;
    }

    // 12. Books by Price Asc
    @Override
    public Page<Book> getBooksByPriceAscending(int page, int size) {

        validatePageAndSize(page, size);

        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books = bookRepository.findByOrderByPriceAsc(pageable);

        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No books found");
        }

        return books;
    }

  
    private void validatePrice(Double price) {
        if (price == null || price <= 0) {
            throw new InvalidParameterException("Price must be greater than zero");
        }
    }

    private void validatePageAndSize(int page, int size) {
        if (page < 0 || size <= 0) {
            throw new InvalidParameterException("Invalid page or size value");
        }
    }
}