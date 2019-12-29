package com.example.java_skill.db.service;

import com.example.java_skill.db.entity.Book;

/**
 * @author fuqiang
 * @version BookService, v0.1 2019/12/29 7:06 下午
 */
public interface BookService {
    Book getById(Integer id);

    boolean testTranscational();

    void testTranscational2();

    void testTranscational3();

    void testTranscational4();
}
