package com.project.librarymanagement.service;

import com.project.librarymanagement.entity.Author;
import com.project.librarymanagement.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AuthorServiceImpl implements AuthorService{
    private AuthorRepository authorRepository;
    @Autowired
     AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author update(Author author , Long authorId) {
        Optional<Author> optional = authorRepository.findById(authorId);// olup olmadigina dair denetim

        if(optional.isPresent()){
            Author newAuthor = optional.get();
            return newAuthor;
        }
        else {
            throw new RuntimeException("Doesn't exist : "+ authorId );
        }

    }
}
