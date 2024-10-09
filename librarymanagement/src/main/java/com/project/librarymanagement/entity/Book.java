package com.project.librarymanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
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

    @ManyToOne(
            cascade = {CascadeType.DETACH , CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Author author;//basic type degil diye one to one/many gibi ilişkisel tip istiyor

    @ManyToOne(
            cascade = {CascadeType.PERSIST , CascadeType.MERGE ,CascadeType.REFRESH , CascadeType.DETACH})
    @JoinColumn(name = "genre_category")
    @JsonBackReference
    private Category genre;

    @OneToMany(mappedBy = "book",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH , CascadeType.MERGE ,CascadeType.PERSIST , CascadeType.REFRESH}
            )
    @JsonManagedReference
    private Set<Loan> loans;

    public Book(){

    }

    public Book(String title, String isbn, String publisher, int year, int copies) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.year = year;
        this.copies = copies;
    }

    public Book(String title, String isbn, String publisher, int year, int copies, Author author, Category genre) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.year = year;
        this.copies = copies;
        this.author = author;
        this.genre = genre;
    }

    public Book(Long id, String title, Author author, String isbn, String publisher, int year, int copies, Category genre, Set<Loan> loans) {
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getGenre() {
        return genre;
    }

    public void setGenre(Category genre) {
        this.genre = genre;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }
}
