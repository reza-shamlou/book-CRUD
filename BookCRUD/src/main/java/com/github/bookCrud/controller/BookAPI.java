package com.github.bookCrud.controller;

import com.github.bookCrud.entity.Book;
import com.github.bookCrud.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookAPI {
    private final BookService bookService;

    @GetMapping("/createOrUpdate")
    public Book createOrUpdate(Book book){
        try {
            return bookService.update(book);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/remove")
    public Book remove(String isbn){
        try {
            return bookService.remove(isbn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/findAll")
    public List<Book> findAll(){
        return bookService.findAll();
    }

}
