package com.example.java_skill;

import com.alibaba.fastjson.JSONObject;
import com.example.java_skill.jdk8.CartService;
import com.example.java_skill.jdk8.Sku;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@Slf4j
public class JavaSkillApplicationTests {

    @Test
    public void testCart() {
        List<Sku> list = CartService.filterSkuList(CartService.getCartSkuList(),
                (Sku sku) -> sku.getTotalPrice() > 2000);
       log.info("list is: {}", JSONObject.toJSONString(list, true));
    }

}
