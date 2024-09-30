package com.project.librarymanagement.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    private Long id;
    @Column(name = "title")
    private String title;
    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    private Author author;//basic type degil diye one to one/many gibi ilişkisel tip istiyor
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "year")
    private int year;
    @Column(name = "copies")
    private  int copies;
    @ManyToOne(cascade = {CascadeType.PERSIST , CascadeType.MERGE ,CascadeType.REFRESH , CascadeType.DETACH})
    @JoinColumn(name = "genre_category")
    private Category genre;
    @OneToMany(mappedBy = "book",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH , CascadeType.MERGE ,CascadeType.PERSIST , CascadeType.REFRESH}
            )
    private Set<Author> loans;

    public Book(Long id, String title, Author author, String isbn, String publisher, int year, int copies, Category genre, Set<Author> loans) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.year = year;
        this.copies = copies;
        this.genre = genre;
        this.loans = loans;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public Category getGenre() {
        return genre;
    }

    public void setGenre(Category genre) {
        this.genre = genre;
    }

    public Set<Author> getLoans() {
        return loans;
    }

    public void setLoans(Set<Author> loans) {
        this.loans = loans;
    }
}
