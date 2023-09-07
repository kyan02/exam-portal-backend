package com.exam.controller;


import com.exam.Repository.CategoryRepository;
import com.exam.entity.Category;
import com.exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;

    //add Category
    @PostMapping("/category")
    public ResponseEntity<Category> addCategories(@RequestBody Category category) {

        Category createdCategory = categoryService.addCategory(category);

        return ResponseEntity.status(HttpStatus.OK).body(createdCategory);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable("categoryId") Long categoryId){

        Category category = categoryService.getCategory(categoryId);

        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @GetMapping("/allCategories")
    public ResponseEntity<List<Category>> getAllCategory(){

        List<Category> allCategories = categoryService.getAllCategory();

        return  ResponseEntity.status(HttpStatus.OK).body(allCategories);
    }

    @PutMapping("/category")
    public ResponseEntity<Category> updateCategories(@RequestBody Category category){

        Category updatedCategory = categoryService.updateCategory(category);

        return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
    }

    @DeleteMapping("/category/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){

        categoryService.deleteCategory(categoryId);
    }
}
