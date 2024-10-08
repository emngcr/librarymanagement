package com.project.librarymanagement.service;

import com.project.librarymanagement.entity.Fine;
import com.project.librarymanagement.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FineServiceImpl implements FineService{
    private FineRepository fineRepository;
    @Autowired
    FineServiceImpl(FineRepository fineRepository){
        this.fineRepository = fineRepository;
    }
    @Override
    public List<Fine> getAll() {
        return fineRepository.findAll();
    }

    @Override
    public void addFine(Fine fine) {
        fineRepository.save(fine);
    }

    @Override
    public Fine getById(Long id) {
        return fineRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        fineRepository.deleteById(id);
    }

    @Override
    public Fine update(Long id) {
        Optional<Fine> res = fineRepository.findById(id);
        if (res.isPresent()){
            Fine fine = res.get();
            return fine;
        }
        else {
            return null;
        }
    }
}
