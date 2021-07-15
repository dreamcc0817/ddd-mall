package com.dreamcc.mall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dreamcc.mall.product.dao.PmsCategoryDao;
import com.dreamcc.mall.product.entity.PmsCategory;
import com.dreamcc.mall.product.service.PmsCategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品三级分类(PmsCategory)表服务实现类
 *
 * @author dreamcc
 * @version v1.0
 * @since 2021-07-13 21:55:57
 */
@Service("pmsCategoryService")
public class PmsCategoryServiceImpl extends ServiceImpl<PmsCategoryDao, PmsCategory> implements PmsCategoryService {

    /**
     * 获取树形菜单
     *
     * @return 树形菜单
     */
    @Override
    public List<PmsCategory> getTreeMenu() {
        List<PmsCategory> allMenus = baseMapper.selectList(null);
        return allMenus.stream().filter(menu -> menu.getParentCid() == 0)
                .peek(menu -> menu.setChildMenu(getChildrens(menu, allMenus)))
                .collect(Collectors.toList());
    }

    /**
     * 递归设置子菜单
     *
     * @param root     父菜单
     * @param allMenus 全部菜单信息
     * @return 树状菜单
     */
    private List<PmsCategory> getChildrens(PmsCategory root, List<PmsCategory> allMenus) {
        return allMenus.stream().filter(pmsCategory -> pmsCategory.getParentCid().equals(root.getCatId()))
                .peek(pmsCategory -> pmsCategory.setChildMenu(getChildrens(pmsCategory, allMenus)))
                .collect(Collectors.toList());
    }
}
