package com.dreamcc.ddd.mall.product.interfaces.facade;


import com.dreamcc.ddd.mall.product.domain.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.R;

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

    private final CategoryService categoryService;

    public CategoryApi(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAssermblyCategory")
    public R getAssermblyCategory() {
        return R.ok().put("result", categoryService.getAssermblyCategory());
    }
}
