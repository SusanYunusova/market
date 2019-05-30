package com.shoppingcenter.market.service;

import com.shoppingcenter.market.model.Category;
import com.shoppingcenter.market.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public ResponseEntity<List<Category>> getAll() {
 List<Category> categoryList = categoryRepository.findAll();
        if (categoryList == null || categoryList.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(categoryList,HttpStatus.OK);
        }
    }
}
