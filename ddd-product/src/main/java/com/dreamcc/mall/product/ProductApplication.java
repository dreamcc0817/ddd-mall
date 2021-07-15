package com.dreamcc.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author cloud-cc
 * @ClassName ProductApplication
 * @Description 产品启动类
 * @date 2021/7/13 20:19
 * @Version 1.0
 */
@MapperScan("com.dreamcc.mall.product.dao")
@SpringBootApplication
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }
}
