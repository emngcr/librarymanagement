package com.project.librarymanagement.entity;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "member")
public class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "member_ship_date")
    private Date memberShipDate;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "member",
               fetch = FetchType.LAZY,
               cascade = {CascadeType.DETACH , CascadeType.MERGE ,CascadeType.PERSIST , CascadeType.REFRESH})
    private Set<Loan> loans;
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY , cascade = {CascadeType.DETACH , CascadeType.MERGE ,CascadeType.PERSIST , CascadeType.REFRESH})
    private Set<Reservation> reservations;

    Member(){

    }

    public Member(String firstName, Date memberShipDate, String email, String phoneNumber) {
        this.firstName = firstName;
        this.memberShipDate = memberShipDate;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    public Member(String firstName, Date memberShipDate, String email, String phoneNumber, Set<Loan> loans, Set<Reservation> reservations) {
        this.firstName = firstName;
        this.memberShipDate = memberShipDate;
        this.email = email;
        this.phoneNumber = phoneNumber;

        this.loans = loans;
        this.reservations = reservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getMemberShipDate() {
        return memberShipDate;
    }

    public void setMemberShipDate(Date memberShipDate) {
        this.memberShipDate = memberShipDate;
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


    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
