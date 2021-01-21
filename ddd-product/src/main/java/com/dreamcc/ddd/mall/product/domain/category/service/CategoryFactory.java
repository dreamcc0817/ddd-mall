package com.dreamcc.ddd.mall.product.domain.category.service;

import com.dreamcc.ddd.mall.product.domain.category.entity.CategoryEntity;
import com.dreamcc.ddd.mall.product.domain.category.repository.po.CategoryPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: Category PO <==> ENTITY 转换工厂类
 * @author dreamcc
 * @date 2021/1/18 14:55
 * @version 1.0
 */
@Service
public class CategoryFactory {

    /**
     * PO转换为ENTITY
     * @param categoryPO PO
     * @return categoryEntity
     */
    public CategoryEntity getCategoryEntiryFromPO(CategoryPO categoryPO){
        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(categoryPO,categoryEntity);
        return categoryEntity;
    }

    /**
     * PO转换为ENTITY
     * @param categoryPOList POLIST
     * @return categoryEntityList
     */
    public List<CategoryEntity> getCategoryEntities(List<CategoryPO> categoryPOList){
        return categoryPOList.stream()
                .map(this::getCategoryEntiryFromPO)
                .collect(Collectors.toList());
    }
}
