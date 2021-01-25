package com.dreamcc.ddd.mall.product.domain.category.repository.facade;

import com.dreamcc.ddd.mall.product.domain.category.repository.po.CategoryPO;

import java.util.List;

/**
 * @description: 目录仓储门面
 * @author dreamcc
 * @date 2021/1/13 21:01
 * @version 1.0
 */
public interface CategoryRepositoryInterface {

    List<CategoryPO> getAllCategory();

    int save(CategoryPO categoryPO);

    int deleteCategory(List<String> id);

    int update(CategoryPO categoryPO);

    CategoryPO categoryInfo(Long id);
}
