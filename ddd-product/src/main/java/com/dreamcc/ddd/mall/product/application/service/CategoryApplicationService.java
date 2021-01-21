package com.dreamcc.ddd.mall.product.application.service;

import com.dreamcc.ddd.mall.product.domain.category.entity.CategoryEntity;
import com.dreamcc.ddd.mall.product.domain.category.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author dreamcc
 * @version 1.0
 * @description: category应用层
 * @date 2021/1/18 15:52
 */
@Service
public class CategoryApplicationService {

    private final CategoryService categoryService;

    public CategoryApplicationService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public List<CategoryEntity> assemblyCategory(){
        return categoryService.getAssermblyCategory();
    }
}
