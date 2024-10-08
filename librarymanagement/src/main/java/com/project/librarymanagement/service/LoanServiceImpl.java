package com.project.librarymanagement.service;

import com.project.librarymanagement.entity.Author;
import com.project.librarymanagement.entity.Fine;
import com.project.librarymanagement.entity.Loan;
import com.project.librarymanagement.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LoanServiceImpl implements LoanService{

    private LoanRepository loanRepository;
    @Autowired
    LoanServiceImpl(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }
    @Override
    public List<Loan> getAll() {
        return loanRepository.findAll();
    }

    @Override
    public Loan addLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public Loan getById(Long id) {
        return  loanRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        loanRepository.deleteById(id);
    }

    @Override
    public Loan update(Loan loan, Long id) {
        Optional<Loan> optional = loanRepository.findById(id);// olup olmadigina dair denetim

        if(optional.isPresent()){
            Loan loan1 = optional.get();
            return loan1;
        }
        else {
            throw new RuntimeException("Doesn't exist : "+ id );
        }
    }
}
