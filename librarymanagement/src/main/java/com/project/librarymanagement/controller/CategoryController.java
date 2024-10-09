package com.project.librarymanagement.controller;

import com.project.librarymanagement.entity.Category;
import com.project.librarymanagement.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;
    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return  categoryService.getById(id);
    }
    @PostMapping
    public void createCategory(@RequestBody Category category){
         categoryService.addCategory(category);
    }
}
