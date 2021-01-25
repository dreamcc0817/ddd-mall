package com.dreamcc.ddd.mall.product.domain.category.service;

import com.dreamcc.ddd.mall.product.domain.category.entity.CategoryEntity;
import com.dreamcc.ddd.mall.product.domain.category.repository.facade.CategoryRepositoryInterface;
import com.dreamcc.ddd.mall.product.domain.category.repository.po.CategoryPO;
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

    /**
     * 保存三级分类
     * @param categoryEntity 三级分类信息
     * @return 保存成功数量
     */
    public int saveCategory(CategoryEntity categoryEntity){
        return categoryRepositoryInterface.save(categoryFactory.createCategoryPO(categoryEntity));
    }

    /**
     * 修改三级分类
     * @param categoryEntity 三级分类信息
     * @return 修改成功数量
     */
    public int updateCategory(CategoryEntity categoryEntity) {
        return categoryRepositoryInterface.update(categoryFactory.createCategoryPO(categoryEntity));
    }
    /**
     * 批量删除目录
     * @param ids 目录ID
     * @return 删除数量
     */
    public int deleteCategory(List<String> ids){
        //TODO 验证是否其他地方有引用
        return categoryRepositoryInterface.deleteCategory(ids);
    }

    public CategoryEntity categoryInfo(Long id) {
        CategoryPO categoryPO = categoryRepositoryInterface.categoryInfo(id);
        return categoryFactory.getCategoryEntiryFromPO(categoryPO);
    }
}
