package com.project.librarymanagement.service;

import com.project.librarymanagement.entity.Fine;

import java.util.List;

public interface FineService {
    List<Fine> getAll();
    void addFine(Fine fine);
    Fine getById(Long id);
    void deleteById(Long id);
    Fine update(Long id);
}
