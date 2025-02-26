package com.github.bookCrud.repository;

import com.github.bookCrud.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book,Long> {
    Book findBookByIsbn(String isbn);
    List<Book> findAllByDeletedIsFalseOrderById();
}
