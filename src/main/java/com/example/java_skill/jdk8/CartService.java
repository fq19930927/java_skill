/*
 * @Copyright: 2018-2019 liuxing All rights reserved.
 */
package com.example.java_skill.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author liuxing
 * @version CartService, v0.1 2019-12-22 00:54
 */
public class CartService {

    /**
     * 购物车集合
     */
    private static List<Sku> carSkuList = new ArrayList<>();

    /**
     * 初始化购物车
     */
    static {
        carSkuList.add(new Sku(654032, "无人机",
                4999.00, 1,
                4999.00, SkuCategoryEnum.ELECTRONICS));

        carSkuList.add(new Sku(642934, "VR一体机",
                2299.00, 1,
                2299.00, SkuCategoryEnum.ELECTRONICS));

        carSkuList.add(new Sku(645321, "纯色衬衫",
                409.00, 3,
                1227.00, SkuCategoryEnum.CLOTHING));

        carSkuList.add(new Sku(654327, "牛仔裤",
                528.00, 1,
                528.00, SkuCategoryEnum.CLOTHING));

        carSkuList.add(new Sku(675489, "跑步机",
                2699.00, 1,
                2699.00, SkuCategoryEnum.SPORTS));

        carSkuList.add(new Sku(644564, "Java编程思想",
                79.80, 1,
                79.80, SkuCategoryEnum.BOOKS));

        carSkuList.add(new Sku(678678, "Java核心技术",
                149.00, 1,
                149.00, SkuCategoryEnum.BOOKS));

        carSkuList.add(new Sku(697894, "算法",
                78.20, 1,
                78.20, SkuCategoryEnum.BOOKS));

        carSkuList.add(new Sku(696968, "TensorFlow进阶指南",
                85.10, 1,
                85.10, SkuCategoryEnum.BOOKS));
    }

    /**
     * 返回所有购物车商品列表
     *
     * @return
     */
    public static List<Sku> getCartSkuList() {
        return carSkuList;
    }

    /**
     * 根据条件筛选购物车集合
     *
     * @param skuList
     * @param predicate
     * @return
     */
    public static List<Sku> filterSkuList(List<Sku> skuList, Predicate<Sku> predicate) {
        return skuList.stream().filter(e -> predicate.test(e)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Sku> list = filterSkuList(getCartSkuList(), (Sku sku) -> sku.getTotalPrice() > 2000); }
}
