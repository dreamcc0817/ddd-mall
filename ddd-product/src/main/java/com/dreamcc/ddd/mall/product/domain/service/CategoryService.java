package com.dreamcc.ddd.mall.product.domain.service;

import com.dreamcc.ddd.mall.product.domain.category.entity.CategoryEntity;
import com.dreamcc.ddd.mall.product.domain.category.repository.facade.CategoryRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepositoryInterface categoryRepositoryInterface;
    private final CategoryFactory categoryFactory;

    public CategoryService(CategoryRepositoryInterface categoryRepositoryInterface,CategoryFactory categoryFactory) {
        this.categoryRepositoryInterface = categoryRepositoryInterface;
        this.categoryFactory = categoryFactory;
    }

    public List<CategoryEntity> getAssermblyCategory() {
        List<CategoryEntity> allEntities = categoryFactory.getCategoryEntities(categoryRepositoryInterface.getAllCategory());
        return allEntities.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .peek(menu-> menu.setChildren(getChildrens(menu,allEntities)))
                .collect(Collectors.toList());
    }

    /**
     * 递归查找所有菜单的子菜单
     * @param root 根节点
     * @param all 所有菜单
     * @return 递归查找所有菜单的子菜单
     */
    private List<CategoryEntity> getChildrens(CategoryEntity root,List<CategoryEntity> all){
        return all.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid().equals(root.getCatId()))
                .peek(categoryEntity -> categoryEntity.setChildren(getChildrens(categoryEntity,all)))
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());
    }
}
