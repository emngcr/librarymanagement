package com.project.librarymanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "author",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH , CascadeType.MERGE ,CascadeType.PERSIST ,CascadeType.REFRESH})
    @JsonManagedReference
    private Set<Book> books;

    public Author(){

    }
    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Author(Long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
