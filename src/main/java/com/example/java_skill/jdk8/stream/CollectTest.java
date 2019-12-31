package com.example.java_skill.jdk8.stream;

import com.alibaba.fastjson.JSONObject;
import com.example.java_skill.jdk8.CartService;
import com.example.java_skill.jdk8.Sku;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 收集器demo
 *
 * @author fuqiang
 * @version CollectTest, v0.1 2019/12/31 10:27 上午
 */
public class CollectTest {

    static List<Sku> cartSkuList = CartService.getCartSkuList();

    public void toList() {
        cartSkuList = cartSkuList.stream().filter(e -> e.getTotalPrice() > 1000)
                .collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(cartSkuList, true));
    }

    /**
     * 分组
     */
    public void group() {
        Map<Enum, List<Sku>> collect = cartSkuList.stream().collect(Collectors.groupingBy(Sku::getSkuCategory));
        System.out.println(JSONObject.toJSONString(collect, true));
    }

    /**
     * 分区
     */
    public void partition() {
        Map<Boolean, List<Sku>> collect = cartSkuList.stream().collect(Collectors.partitioningBy(e -> e.getTotalPrice() > 1000));
        System.out.println(JSONObject.toJSONString(collect, true));
    }

    public static void main(String[] args) {
        new CollectTest().partition();
    }
}
