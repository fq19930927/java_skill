/*
 * @Copyright: 2018-2019 liuxing All rights reserved.
 */
package com.example.java_skill.jdk8.stream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.java_skill.jdk8.CartService;
import com.example.java_skill.jdk8.Sku;
import com.example.java_skill.jdk8.SkuCategoryEnum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author liuxing
 * @version Test, v0.1 2019-12-28 22:49
 */
public class Test {

    public static List<Sku> cartSkuList = CartService.getCartSkuList();

    public static void test() {
        AtomicReference<Double> money = new AtomicReference<>(0.0);
        List<String> nameList = CartService.getCartSkuList()
                .stream()
                .peek(sku -> System.out.println(JSONObject.toJSONString(sku, true)))
                .filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                .limit(2)
                .peek(sku -> money.updateAndGet(v -> v + sku.getTotalPrice()))
                .map(sku -> sku.getSkuName()).collect(Collectors.toList());

        System.out.println("nameList is: " + JSONObject.toJSONString(nameList));
        System.out.println(money);
    }

    /**
     * map:将一个元素转换为另一个元素
     */
    public static void mapTest() {
        List<String> nameList = cartSkuList.stream().map(sku -> sku.getSkuName()).collect(Collectors.toList());
    }

    /**
     * flatMap:将一个对象转换为流
     */
    public static void flatMapTest() {
        cartSkuList.stream().flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(e -> System.out.println(JSON.toJSONString(e, true)));
    }

    /**
     * peek:无状态的中间操作
     */
    public static void peekTest() {
        cartSkuList.stream().peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(e -> System.out.println(JSON.toJSONString(e, true)));
    }

    /**
     * sorted:有状态的中间操作
     */
    public static void sortedTest() {
        cartSkuList.stream().peek(sku -> System.out.println(sku.getSkuName()))
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                .forEach(e -> System.out.println(JSON.toJSONString(e, true)));
    }

    /**
     * distinct:有状态的中间操作
     */
    public static void distinctTest() {
        cartSkuList.stream().map(sku -> sku.getSkuCategory())
                .distinct()
                .forEach(e -> System.out.println(e));
    }


    public static void main(String[] args) {
        distinctTest();
    }

}
