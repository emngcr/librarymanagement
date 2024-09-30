package com.project.librarymanagement.service;

import com.project.librarymanagement.entity.Author;
import com.project.librarymanagement.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    Book getById(Long id);
    Book addBook(Book book );
    void delete(Long id);
}
