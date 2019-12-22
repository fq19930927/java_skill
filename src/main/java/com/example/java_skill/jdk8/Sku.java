/*
 * @Copyright: 2018-2019 liuixng All rights reserved.
 */
package com.example.java_skill.jdk8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品信息
 * @author liuxing
 * @version Sku, v0.1 2019-12-22 00:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sku implements Serializable {
    /**
     * 商品编号
     */
    private Integer skuId;

    /**
     * 商品名称
     */
    private String skuName;

    /**
     * 单价
     */
    private Double skuPrice;

    /**
     * 购买个数
     */
    private Integer totalNum;

    /**
     * 总价
     */
    private Double totalPrice;

    /**
     * 商品类型
     */
    private Enum skuCategory;
}
