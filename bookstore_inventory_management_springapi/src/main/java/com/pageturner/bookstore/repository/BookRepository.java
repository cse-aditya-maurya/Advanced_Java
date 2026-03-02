package com.pageturner.bookstore.repository;

import com.pageturner.bookstore.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // 1. Find all books by author
    List<Book> findByAuthor(String author);

    // 2. List books of a specific genre (with pagination)
    Page<Book> findByGenre(String genre, Pageable pageable);

    // 3. Find books cheaper than a given price
    List<Book> findByPriceLessThan(Double price);

    // 4. Find books more expensive than a given price
    List<Book> findByPriceGreaterThan(Double price);

    // 5. Retrieve books published after a specific date
    List<Book> findByPublishedDateAfter(LocalDate date);

    // 6. Retrieve books published before a specific date
    List<Book> findByPublishedDateBefore(LocalDate date);

    // 7. Search books whose title contains a keyword
    List<Book> findByTitleContaining(String keyword);

    // 8. Search books whose title starts with a keyword
    List<Book> findByTitleStartingWith(String prefix);

    // 9. Search books whose title ends with a keyword
    List<Book> findByTitleEndingWith(String suffix);

    // 10. Find books by genre AND author
    List<Book> findByGenreAndAuthor(String genre, String author);

    // 11. Find books by genre OR author
    List<Book> findByGenreOrAuthor(String genre, String author);

    // 12. Find books by price range
    List<Book> findByPriceBetween(Double minPrice, Double maxPrice);

    // 13. List books by genre below a certain price
    List<Book> findByGenreAndPriceLessThan(String genre, Double price);

    // 14. List all books ordered by published date descending (with pagination)
    Page<Book> findByOrderByPublishedDateDesc(Pageable pageable);

    // 15. List all books ordered by price ascending (with pagination)
    Page<Book> findByOrderByPriceAsc(Pageable pageable);
}