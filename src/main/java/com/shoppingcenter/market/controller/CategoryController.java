package com.shoppingcenter.market.controller;


import com.shoppingcenter.market.dto.CategoryDto;
import com.shoppingcenter.market.service.CategoryService;
import com.shoppingcenter.market.utils.CategoryConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//todo fixtheitemcontroller
//todo connettodatabase
//todo fixthegetpostmetods
//todo
@RestController
@RequestMapping("/api/v1/shop")
public class CategoryController {
    private CategoryService categoryService;
    private CategoryConversion categoryConversion;
    @Autowired
    public CategoryController(CategoryService categoryService, CategoryConversion categoryConversion) {
        this.categoryService=categoryService;
        this.categoryConversion=categoryConversion;
    }
//controller dto ile ishleyir
    @PostMapping("/categories")
    public ResponseEntity<CategoryDto> createNewCategory(@RequestBody CategoryDto categoryDto){

       return new ResponseEntity<>(categoryConversion.toCategoryDto(categoryService.
                               saveCategory(categoryConversion.toCategory(categoryDto))),
               HttpStatus.CREATED);
    }
    @GetMapping("/categories")
    public  ResponseEntity<List<CategoryDto>> getAll(){


return new ResponseEntity<>(categoryConversion.toListCategoryDto(categoryService.getAll()),HttpStatus.OK);
    }


    @DeleteMapping("/categories")
    public  ResponseEntity<String> deleteCategory(@PathVariable("categoryId") int categoryId){
        categoryService.deleteCategoryById(categoryId);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

    @PutMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("categoryId") int categoryId,@RequestBody CategoryDto categoryDto){
        categoryService.updateCategory(categoryId,categoryConversion.toCategory(categoryDto));

    }

    /*@PatchMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryDto> patchCategory(){
        return null;
    }
*/
}
