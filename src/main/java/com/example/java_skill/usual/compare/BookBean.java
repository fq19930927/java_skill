package com.example.java_skill.usual.compare;

import lombok.Data;

import java.io.Serializable;

/**
 * Comparable 自然排序
 * Comparator 定制排序
 * @author fuqiang
 * @version BookBean, v0.1 2019/12/30 2:15 下午
 */
@Data
public class BookBean implements Serializable, Comparable {

    private String name;
    private int count;

    @Override
    public int compareTo(Object o) {
        if (o instanceof BookBean){
            BookBean anotherBook = (BookBean) o;
            int result;

            //比如这里按照书价排序
            result = getCount() - anotherBook.getCount();

            //或者按照 String 的比较顺序
            //result = getName().compareTo(anotherBook.getName());

            if (result == 0){   //当书价一致时，再对比书名。 保证所有属性比较一遍
                result = getName().compareTo(anotherBook.getName());
            }
            return result;
        }
        // 一样就返回 0
        return 0;
    }
}
