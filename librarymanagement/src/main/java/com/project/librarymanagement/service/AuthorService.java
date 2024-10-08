package com.project.librarymanagement.service;

import com.project.librarymanagement.entity.Author;

import java.util.List;

public interface AuthorService {
        List<Author> getAll();
        Author addAuthor(Author author);
        Author getById(Long id);
        void  deleteById(Long id);
        Author update(Author author , Long authorId);

}
