package com.pageturner.bookstore.controller;

import com.pageturner.bookstore.entity.Book;
import com.pageturner.bookstore.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 1. Get books by author
    @GetMapping("/author")
    public ResponseEntity<List<Book>> getBooksByAuthor(
            @RequestParam String author) {

        List<Book> books = bookService.getBooksByAuthor(author);
        return ResponseEntity.ok(books);
    }

    // 2. Get books by genre (paginated)
    @GetMapping("/genre")
    public ResponseEntity<Page<Book>> getBooksByGenre(
            @RequestParam String genre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<Book> books = bookService.getBooksByGenre(genre, page, size);
        return ResponseEntity.ok(books);
    }

    // 3. Get books cheaper than price
    @GetMapping("/cheaper")
    public ResponseEntity<List<Book>> getBooksCheaperThan(
            @RequestParam Double maxPrice) {

        List<Book> books = bookService.getBooksCheaperThan(maxPrice);
        return ResponseEntity.ok(books);
    }

    // 4. Get books more expensive than price
    @GetMapping("/expensive")
    public ResponseEntity<List<Book>> getBooksMoreExpensiveThan(
            @RequestParam Double minPrice) {

        List<Book> books = bookService.getBooksMoreExpensiveThan(minPrice);
        return ResponseEntity.ok(books);
    }

    // 5. Get books published after date
    @GetMapping("/new-arrivals")
    public ResponseEntity<List<Book>> getBooksPublishedAfter(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate publishedAfter) {

        List<Book> books = bookService.getBooksPublishedAfter(publishedAfter);
        return ResponseEntity.ok(books);
    }

    // 6. Search books by title keyword
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(
            @RequestParam String keyword) {

        List<Book> books = bookService.searchBooksByTitleKeyword(keyword);
        return ResponseEntity.ok(books);
    }

    // 7. Get books by genre AND author
    @GetMapping("/genre-author")
    public ResponseEntity<List<Book>> getBooksByGenreAndAuthor(
            @RequestParam String genre,
            @RequestParam String author) {

        List<Book> books = bookService.getBooksByGenreAndAuthor(genre, author);
        return ResponseEntity.ok(books);
    }

    // 8. Get books by genre OR author
    @GetMapping("/genre-or-author")
    public ResponseEntity<List<Book>> getBooksByGenreOrAuthor(
            @RequestParam String genre,
            @RequestParam String author) {

        List<Book> books = bookService.getBooksByGenreOrAuthor(genre, author);
        return ResponseEntity.ok(books);
    }

    // 9. Get books within price range
    @GetMapping("/price-range")
    public ResponseEntity<List<Book>> getBooksByPriceRange(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {

        List<Book> books = bookService.getBooksByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(books);
    }

    // 10. Get books by genre below certain price
    @GetMapping("/genre-discount")
    public ResponseEntity<List<Book>> getBooksByGenreBelowPrice(
            @RequestParam String genre,
            @RequestParam Double maxPrice) {

        List<Book> books = bookService.getBooksByGenreBelowPrice(genre, maxPrice);
        return ResponseEntity.ok(books);
    }

    // 11. List latest books (published date desc)
    @GetMapping("/latest")
    public ResponseEntity<Page<Book>> getLatestBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<Book> books = bookService.getLatestBooks(page, size);
        return ResponseEntity.ok(books);
    }

    // 12. List books ordered by price ascending
    @GetMapping("/by-price")
    public ResponseEntity<Page<Book>> getBooksByPriceAsc(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<Book> books = bookService.getBooksByPriceAscending(page, size);
        return ResponseEntity.ok(books);
    }
}