package com.project.librarymanagement.service;

import com.project.librarymanagement.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(Long id);
    void addCategory(Category category);
}
