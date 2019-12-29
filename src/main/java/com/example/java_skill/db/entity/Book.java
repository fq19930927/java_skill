package com.example.java_skill.db.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fuqiang
 * @version Book, v0.1 2019/12/29 7:03 下午
 */
@Data
public class Book implements Serializable {

    private Integer id;

    private String name;

    private String author;

    private Double price;
}
