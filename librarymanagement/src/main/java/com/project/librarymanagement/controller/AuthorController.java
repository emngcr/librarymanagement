package com.project.librarymanagement.controller;

import com.project.librarymanagement.entity.Author;
import com.project.librarymanagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private AuthorService authorService;

    AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }
    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAll();
    }
    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }
    @GetMapping("/{authorid}")
    public Author getAuthorById(@PathVariable Long id){
        return authorService.getById(id);
    }
    @PutMapping("/{authorid}")
    public Author updateAuthorById(@RequestBody Author author, @PathVariable Long id){
        return authorService.update(author , id);
    }
    @DeleteMapping("/{authorid}")
    public void deleteAuthorById(@PathVariable Long id){
        authorService.deleteById(id);
    }

}
