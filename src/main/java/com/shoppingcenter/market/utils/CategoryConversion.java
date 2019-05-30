package com.shoppingcenter.market.utils;

import com.shoppingcenter.market.dto.CategoryDto;
import com.shoppingcenter.market.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConversion {
//service modelle ishleyir



    public Category toCategory(CategoryDto categoryDto){
        Category category=new Category();
        category.setId(categoryDto.getCategoryId());
        category.setName(categoryDto.getCategoryName());
        return category;
    }


    public CategoryDto toCategoryDto(Category category){
        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setCategoryId(category.getId());
        categoryDto.setCategoryName(category.getName());
        return categoryDto;
    }

}
