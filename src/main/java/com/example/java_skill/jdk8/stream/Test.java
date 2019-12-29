/*
 * @Copyright: 2018-2019 liuxing All rights reserved.
 */
package com.example.java_skill.jdk8.stream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.java_skill.jdk8.CartService;
import com.example.java_skill.jdk8.Sku;
import com.example.java_skill.jdk8.SkuCategoryEnum;

import java.util.*;
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

    /**
     * skip:有状态的中间操作(跳过前n条数据)
     */
    public static void skipTest() {
        cartSkuList.stream().sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(6)
                .forEach(e -> System.out.println(JSON.toJSONString(e, true)));
    }

    /**
     * limit:有状态的中间操作，可以与skip结合模拟分页效果
     */
    public static void limitTest() {
        cartSkuList.stream().sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(1 * 3)
                .limit(3)
                .forEach(e -> System.out.println(JSON.toJSONString(e, true)));
    }

    /**
     * allMatch:终端短路操作，是否全部匹配
     */
    public static void allMatchTest() {
        boolean match = cartSkuList.stream().allMatch(e -> e.getTotalPrice() > 1000);
        System.out.println(match);
    }

    /**
     * anyMatch:终端短路操作，是否有一个及以上匹配
     */
    public static void anyMatchTest() {
        boolean match = cartSkuList.stream().anyMatch(e -> e.getTotalPrice() > 1000);
        System.out.println(match);
    }

    /**
     * noneMatch:终端短路操作，是否所有都匹配不上
     */
    public static void noneMatchTest() {
        boolean match = cartSkuList.stream().noneMatch(e -> e.getTotalPrice() > 1000);
        System.out.println(match);
    }

    /**
     * findFirst:终端短路操作,找到第一个
     */
    public static void findFirstTest() {
        Optional<Sku> optional = cartSkuList.stream().findFirst();
        System.out.println(JSONObject.toJSONString(optional.get(), true));
    }

    /**
     * findAny:终端短路操作,找到任意一个(并行时比findFirst快)
     */
    public static void findAnyTest() {
        Optional<Sku> optional = cartSkuList.stream().findAny();
        System.out.println(JSONObject.toJSONString(optional.get(), true));
    }

    /**
     * max:终端非短路操作,找到最大值
     */
    public static void maxTest() {
        OptionalDouble max = cartSkuList.stream().mapToDouble(Sku::getTotalPrice).max();
        System.out.println(JSONObject.toJSONString(max.getAsDouble(), true));
    }

    /**
     * count:终端非短路操作,总数
     */
    public static void countTest() {
        long count = cartSkuList.stream().count();
        System.out.println(count);;
    }


    public static void main(String[] args) {
        countTest();
    }

}
