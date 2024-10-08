package com.project.librarymanagement.model;

import com.project.librarymanagement.entity.Author;
import jakarta.persistence.Entity;


public class BookResponse {
    private long id;
    private String name;
    private AuthorDto authorDto;

    public BookResponse() {
    }

    public BookResponse(long id, String name, AuthorDto authorDto) {
        this.id = id;
        this.name = name;
        this.authorDto = authorDto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorDto getAuthorDto() {
        return authorDto;
    }

    public void setAuthorDto(AuthorDto authorDto) {
        this.authorDto = authorDto;
    }
}
