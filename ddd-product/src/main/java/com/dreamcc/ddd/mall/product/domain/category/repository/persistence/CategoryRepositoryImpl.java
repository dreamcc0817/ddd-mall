package com.dreamcc.ddd.mall.product.domain.category.repository.persistence;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dreamcc.ddd.mall.product.domain.category.repository.facade.CategoryRepositoryInterface;
import com.dreamcc.ddd.mall.product.domain.category.repository.mapper.CategoryDao;
import com.dreamcc.ddd.mall.product.domain.category.repository.po.CategoryPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dreamcc
 * @version 1.0
 * @description: 仓储实现完成数据持久化和数据库查询
 * @date 2021/1/13 21:38
 */
@Repository
public class CategoryRepositoryImpl  implements CategoryRepositoryInterface {

    private final CategoryDao categoryDao;

    public CategoryRepositoryImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<CategoryPO> getAllCategory() {
        return categoryDao.selectList(Wrappers.emptyWrapper());
    }
}
