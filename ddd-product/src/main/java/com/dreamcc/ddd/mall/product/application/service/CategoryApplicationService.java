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

    /**
     * 获取三级目录
     * @return 三级目录
     */
    public List<CategoryEntity> getAssermblyCategory(){
        List list = categoryService.getAssermblyCategory();
        return categoryService.getAssermblyCategory();
    }

    public void saveCategory(CategoryEntity categoryEntity){
        categoryService.saveCategory(categoryEntity);
    }


    public void updateCategory(CategoryEntity categoryEntity) {
        categoryService.updateCategory(categoryEntity);
    }

    /**
     * 删除目录
     * @param ids 目录ID
     * @return 删除数量
     */
    public int deleteCategory(List<String> ids){
        return categoryService.deleteCategory(ids);
    }

    public CategoryEntity categoryInfo(Long id) {
        return categoryService.categoryInfo(id);
    }
}
