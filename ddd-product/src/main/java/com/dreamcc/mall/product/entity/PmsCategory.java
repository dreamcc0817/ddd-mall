package com.dreamcc.mall.product.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * 商品三级分类(PmsCategory)表实体类
 *
 * @author dreamcc
 * @version v1.0
 * @since 2021-07-13 21:55:50
 */
@Data
@TableName
public class PmsCategory implements Serializable {

    private static final long serialVersionUID = -1;
    /**
     * 分类id
     */
    @TableId
    private Long catId;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 父分类id
     */
    private Long parentCid;
    /**
     * 层级
     */
    private Integer catLevel;
    /**
     * 是否显示[0-不显示，1显示]
     */
    @TableLogic(value = "1",delval = "0")
    private Integer showStatus;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 图标地址
     */
    private String icon;
    /**
     * 计量单位
     */
    private String productUnit;
    /**
     * 商品数量
     */
    private Integer productCount;
    /**
     * 子菜单
     */
    @TableField(exist = false)
    private List<PmsCategory> childMenu;
}
