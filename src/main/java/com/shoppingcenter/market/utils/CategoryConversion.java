package com.shoppingcenter.market.utils;

import com.shoppingcenter.market.dto.CategoryDto;
import com.shoppingcenter.market.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<CategoryDto> toListCategoryDto(List<Category> categoryList){
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        if(categoryList.size()== 0){

            return  categoryDtoList;

        }else {
            for (Category category : categoryList) {
              categoryDtoList.add( toCategoryDto(category)) ;

            }
            return  categoryDtoList;
        }
    }

}
