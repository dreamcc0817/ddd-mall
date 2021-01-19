package com.dreamcc.ddd.mall.product.domain.category.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dreamcc.ddd.mall.product.domain.category.repository.po.CategoryPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 目录分类Dao
 * @author dreamcc
 * @date 2021/1/13 21:45
 * @version 1.0
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryPO> {
}
