package com.project.librarymanagement.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "member")
public class Member {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "membership_date")
    private Date membershipDate;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "active")
    private boolean isActive;
    @OneToMany(mappedBy = "member",
               fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private Set<Author> loans;
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    public Member(Long id, String name, Date membershipDate, String email, String phoneNumber, boolean isActive, Set<Author> loans, Set<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.membershipDate = membershipDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.loans = loans;
        this.reservations = reservations;
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

    public Date getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Author> getLoans() {
        return loans;
    }

    public void setLoans(Set<Author> loans) {
        this.loans = loans;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
