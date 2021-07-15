package com.dreamcc.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dreamcc.mall.product.entity.PmsCategory;

import java.util.List;

/**
 * 商品三级分类(PmsCategory)表服务接口
 *
 * @author dreamcc
 * @version v1.0
 * @since 2021-07-13 21:55:55
 */
public interface PmsCategoryService extends IService<PmsCategory> {

    /**
     * 获取树形菜单
     *
     * @return 树形菜单
     */
    List<PmsCategory> getTreeMenu();
}
