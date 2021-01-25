package com.dreamcc.ddd.mall.product.interfaces.facade;


import com.dreamcc.ddd.mall.product.application.service.CategoryApplicationService;
import com.dreamcc.ddd.mall.product.domain.category.entity.CategoryEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import utils.R;

import java.util.List;

/**
 * @author dreamcc
 * @version 1.0
 * @description: category api接口
 * @date 2021/1/18 16:08
 */
@RestController
@Slf4j
@RequestMapping("/category")
public class CategoryApi {

    private final CategoryApplicationService categoryService;

    public CategoryApi(CategoryApplicationService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAssermblyCategory")
    public R getAssermblyCategory() {
        return R.ok().put("result", categoryService.getAssermblyCategory());
    }

    @PostMapping("/deleteCategory")
    public R deleteCategory(@RequestBody List<String> ids) {
        categoryService.deleteCategory(ids);
        return R.ok();
    }

    @PostMapping("/saveCategory")
    public R saveCategory(@RequestBody CategoryEntity categoryEntity) {
        categoryService.saveCategory(categoryEntity);
        return R.ok();
    }

    @PostMapping("/updateCategory")
    public R updateCategory(@RequestBody CategoryEntity categoryEntity){
        categoryService.updateCategory(categoryEntity);
        return R.ok();
    }

    @GetMapping("/info/{id}")
    public R categoryInfo(@PathVariable Long id){
        return R.ok().put("data",categoryService.categoryInfo(id));
    }
}
