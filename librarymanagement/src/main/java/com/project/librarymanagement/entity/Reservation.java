package com.project.librarymanagement.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    private Long id;
    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE ,CascadeType.PERSIST , CascadeType.REFRESH})
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE ,CascadeType.PERSIST , CascadeType.REFRESH})
    @JoinColumn(name = "member_id")
    private Member member;
    @Column(name = "reservation_date")
    private Date resDate;

    public enum ReservationStatus{
        PENING , COMPLETED , CANCELED
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "reservation_status")
    private ReservationStatus reservationStatus;

    public Reservation(Long id, Book book, Member member, Date resDate, ReservationStatus reservationStatus) {
        this.id = id;
        this.book = book;
        this.member = member;
        this.resDate = resDate;
        this.reservationStatus = reservationStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
