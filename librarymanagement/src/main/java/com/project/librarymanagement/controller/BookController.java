package com.project.librarymanagement.controller;

import com.project.librarymanagement.entity.Book;
import com.project.librarymanagement.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
// update kismi yok  , kitaplarin update olmasini istemedik
public class BookController {
    private BookService bookService;

    BookController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }
    @PostMapping
    public Book createBook(@RequestBody  Book book){
        return bookService.addBook(book);
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id){
        bookService.delete(id);
    }
}
