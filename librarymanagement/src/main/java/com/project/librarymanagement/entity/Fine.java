package com.project.librarymanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "fine")
public class Fine {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "amount")
    private double amount;

    public enum FineStatus {
        PAID , UNPAID
    }
    @Column(name = "fine_status")
    private FineStatus fineStatus;
    @JsonManagedReference
    @OneToOne(mappedBy = "fine",
            cascade = {CascadeType.DETACH , CascadeType.MERGE ,CascadeType.PERSIST , CascadeType.REFRESH})

    private Loan loan;

    Fine(){

    }

    public Fine(Loan loan, double amount , FineStatus fineStatus) {
        this.loan = loan;
        this.amount = amount;
        this.fineStatus = fineStatus;
    }

    public Fine(Long id, Loan loan, double amount, FineStatus fineStatus) {
        this.id = id;
        this.loan = loan;
        this.amount = amount;
        this.fineStatus = fineStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public FineStatus getFineStatus() {
        return fineStatus;
    }

    public void setFineStatus(FineStatus fineStatus) {
        this.fineStatus = fineStatus;
    }
}
