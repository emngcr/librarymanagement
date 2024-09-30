package com.project.librarymanagement.service;

import com.project.librarymanagement.entity.Category;
import com.project.librarymanagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;
    @Autowired
    CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }
}
