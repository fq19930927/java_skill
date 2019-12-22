/*
 * @Copyright: 2018-2019 liuxing All rights reserved.
 */
package com.example.java_skill.jdk8.stream;

/**
 * 商品类型枚举
 * @author liuxing
 * @version SkuCategoryEnum, v0.1 2019-12-22 00:59
 */
public enum SkuCategoryEnum {

    CLOTHING(10, "服装类"),
    ELECTRONICS(20, "数码类"),
    SPORTS(30, "运动类"),
    BOOKS(40, "图书类");

    /**
     * 商品类型的编号
     */
    private Integer code;

    /**
     * 商品类型的名称
     */
    private String name;

    /**
     * 构造函数
     * @param code
     * @param name
     */
    SkuCategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
