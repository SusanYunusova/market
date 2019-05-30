package com.shoppingcenter.market.service;

import com.shoppingcenter.market.model.Category;
import com.shoppingcenter.market.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;


    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAll() {

            return categoryRepository.findAll();
        }


    public ResponseEntity<String> deleteCategoryById(int categoryId) {

        try {
            categoryRepository.deleteById(categoryId);
            return new ResponseEntity<>("Category deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    public Category updateCategory(int categoryId, Category category) {
        Optional<Category>  optionalCategory=  categoryRepository.findById(categoryId);
        if(optionalCategory.isPresent()){
            category.setId(categoryId);
            Category categoryNew = categoryRepository.save(category);

            return categoryNew;
        }
        throw new  RuntimeException();
    }
}
