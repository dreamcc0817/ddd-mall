package com.dreamcc.mall.product.controller;

import com.dreamcc.mall.product.entity.PmsCategory;
import com.dreamcc.mall.product.service.PmsCategoryService;
import org.springframework.web.bind.annotation.*;
import utils.R;

import java.util.Arrays;
import java.util.List;

/**
 * 商品三级分类(PmsCategory)表控制层
 *
 * @author dreamcc
 * @version v1.0
 * @since 2021-07-13 22:03:22
 */
@RestController
@RequestMapping("/category")
public class PmsCategoryController {
    /**
     * 服务对象
     */
    private final PmsCategoryService pmsCategoryService;

    public PmsCategoryController(PmsCategoryService pmsCategoryService) {
        this.pmsCategoryService = pmsCategoryService;
    }

    /**
     * 获取树形菜单
     *
     * @return 树形菜单
     */
    @GetMapping("/getTreeMenu")
    public R getTreeMenu() {
        List<PmsCategory> menus = pmsCategoryService.getTreeMenu();
        return R.ok().put(menus);
    }

    @GetMapping("/{id}")
    public R getMenuInfo(@PathVariable Integer id){
        return R.ok().put(pmsCategoryService.getById(id));
    }
    /**
     * 保存目录
     *
     * @param pmsCategory 保存目录
     * @return 保存结果
     */
    @RequestMapping("/save")
    public R save(@RequestBody PmsCategory pmsCategory) {
        pmsCategoryService.save(pmsCategory);
        return R.ok();
    }

    @PostMapping("/update")
    public R update(@RequestBody PmsCategory pmsCategory){
        pmsCategoryService.saveOrUpdate(pmsCategory);
        return R.ok();
    }

    /**
     * 删除菜单
     *
     * @param catIds id
     * @return 成功消息
     */
    @PostMapping("/delete")
    public R deleteMenus(@RequestBody Long[] catIds) {
        return R.ok().put(pmsCategoryService.removeByIds(Arrays.asList(catIds)));
    }

}
