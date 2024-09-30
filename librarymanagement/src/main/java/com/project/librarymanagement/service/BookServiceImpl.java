package com.project.librarymanagement.service;

import com.project.librarymanagement.entity.Author;
import com.project.librarymanagement.entity.Book;
import com.project.librarymanagement.repository.AuthorRepository;
import com.project.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService{
    // update yazilmadi
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    @Autowired
    BookServiceImpl(BookRepository bookRepository , AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);

    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
