package com.dreamcc.ddd.mall.product.domain.category.repository.facade;

import com.dreamcc.ddd.mall.product.domain.category.repository.po.CategoryPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 目录仓储门面
 * @author dreamcc
 * @date 2021/1/13 21:01
 * @version 1.0
 */
@Repository
public interface CategoryRepositoryInterface {
    List<CategoryPO> getAllCategory();
}
