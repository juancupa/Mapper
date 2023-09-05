package com.mapstructlombok.mapper;

import com.mapstructlombok.dto.GetCategory;
import com.mapstructlombok.entity.Category;
import com.mapstructlombok.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CategoryMapper {


    @Autowired
   private   CategoryRepository categoryRepository ;
    abstract GetCategory toGetCategory(Category category);


    Category toEntity(GetCategory getCategory){
        if(getCategory == null) return  null;
        Category category= categoryRepository.findById(getCategory.getCategoryId()).orElse(null);

        if (category == null)return null;

        category.setId(getCategory.getCategoryId());
        category.setName(getCategory.getCategoryName());

        return category;

    }

   abstract List<GetCategory> toGetCategoryList(List<Category> categoryList);

   abstract List<Category> toEntityList(List<GetCategory> getCategories);
}
