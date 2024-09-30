package com.project.librarymanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fine")
public class Fine {
    @Id
    private Long id;
    @OneToOne(mappedBy = "fine",
            cascade = {CascadeType.DETACH , CascadeType.MERGE ,CascadeType.PERSIST , CascadeType.REFRESH})
    private Author loan;
    @Column(name = "amount")
    private double amount;

    public enum FineStatus {
        PAID , UNPAID
    }
    @Column(name = "fine_status")
    private FineStatus fineStatus;

    public Fine(Long id, Author loan, double amount, FineStatus fineStatus) {
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

    public Author getLoan() {
        return loan;
    }

    public void setLoan(Author loan) {
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
