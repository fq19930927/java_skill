package com.example.java_skill.db.mapper;

import com.example.java_skill.db.entity.Book;

import java.util.List;

/**
 * @author fuqiang
 * @version BookMapper, v0.1 2019/12/29 7:05 下午
 */
public interface BookMapper {
    int insert(Book record);
    List<Book> selectAll();
    Book getById(Integer id);
}
