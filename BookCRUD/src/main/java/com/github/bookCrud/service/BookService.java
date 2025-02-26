package com.github.bookCrud.service;

import com.github.bookCrud.entity.Book;
import com.github.bookCrud.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    @Transactional(rollbackFor = Exception.class)
    public Book update(Book updateBook ){
        Book existingBook = bookRepository.findBookByIsbn(updateBook.getIsbn());
        if (existingBook!=null) {
                existingBook.setIsbn(updateBook.getIsbn());
            if (updateBook.getTitle()!=null) {
                existingBook.setTitle(updateBook.getTitle());
            }
            if (updateBook.getAuthor()!=null){
                existingBook.setAuthor(updateBook.getAuthor());
            }
            bookRepository.save(existingBook);
        }else {
            existingBook = updateBook;
        }

        return bookRepository.save(existingBook);
    }

    @Transactional(rollbackFor = {Exception.class})
    public Book remove(String isbn) throws Exception {
            Book book = bookRepository.findBookByIsbn(isbn);
            book.setDeleted(true);
            return bookRepository.save(book);
    }


    public List<Book> findAll(){
        return bookRepository.findAllByDeletedIsFalseOrderById();
    }

}
