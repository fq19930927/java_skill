/*
 * @Copyright: 2018-2019 liuxing All rights reserved.
 */
package com.example.java_skill.jdk8.stream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.java_skill.jdk8.CartService;
import com.example.java_skill.jdk8.Sku;
import com.example.java_skill.jdk8.SkuCategoryEnum;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author liuxing
 * @version Test, v0.1 2019-12-28 22:49
 */
public class Test {

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

    public static void main(String[] args) {

        test();
    }

}
