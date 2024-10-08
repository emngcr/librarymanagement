package com.project.librarymanagement.service;

import com.project.librarymanagement.entity.Loan;

import java.util.List;

public interface LoanService {
    List<Loan> getAll();
    Loan addLoan(Loan loan);
    Loan getById(Long id);
    void  deleteById(Long id);
    Loan update(Loan loan , Long id);
}
