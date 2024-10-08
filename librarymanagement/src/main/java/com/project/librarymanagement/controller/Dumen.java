package com.project.librarymanagement.controller;

import jakarta.persistence.Column;

public class Dumen {
    @Column(name = "title")
    private String title;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "year")
    private int year;
    @Column(name = "copies")
    private  int copies;
}
