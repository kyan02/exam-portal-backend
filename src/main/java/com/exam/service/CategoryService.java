package com.exam.service;

import com.exam.Repository.CategoryRepository;
import com.exam.entity.Category;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryService {

  @Autowired CategoryRepository categoryRepository;

  public Category addCategory(Category category) {

    Category existingCategory =
        categoryRepository.findOneByNameAndIsActive(category.getName(), Boolean.TRUE);

    if(Objects.nonNull(existingCategory)){

    }
    category.setIsActive(Boolean.TRUE);
    category.setCreatedTime(DateTime.now().toDate());
    Category newCategory = categoryRepository.save(category);

    return newCategory;
  }

  public Category getCategory(Long categoryId) {

    Category category = categoryRepository.findById(categoryId).get();

    return category;
  }

  public List<Category> getAllCategory(){

    return categoryRepository.findAll();
  }

  public Category updateCategory(Category category){

    Category existingCategory = categoryRepository.findOneByNameAndIsActive(category.getName(), Boolean.TRUE);

    if(Objects.nonNull(existingCategory)){
      existingCategory.setName(category.getName());
      existingCategory.setDescription(category.getDescription());
      existingCategory.setIsActive(Boolean.TRUE);
      categoryRepository.save(existingCategory);
    }

    return existingCategory;
  }

  public void deleteCategory(Long categoryId){

    Category category = categoryRepository.findById(categoryId).get();
    category.setIsActive(Boolean.FALSE);

    categoryRepository.save(category);
  }
}
