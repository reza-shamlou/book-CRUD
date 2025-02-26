package com.github.bookCrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.*;


@Entity(name = "book")
@Table(name = "book",
        indexes = {@Index(name = "isbn_indx", columnList = "isbn", unique = true)})
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends SuperEntity{
    @Column(nullable = false)
    private String isbn;

    private String author;
    private String title;
    private boolean deleted = Boolean.FALSE;

}
