package com.example.java_skill.db.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.java_skill.db.entity.Book;
import com.example.java_skill.db.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fuqiang
 * @version BookController, v0.1 2019/12/29 7:05 下午
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("getBook/{id}")
    public String getBook(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        return JSONObject.toJSONString(book);
    }

    @GetMapping("/testTransactional")
    public String test() {
        bookService.testTranscational();
        return "SUCCESS";
    }

    @GetMapping("/testTransactional2")
    public String test2() {
        bookService.testTranscational2();
        return "SUCCESS";
    }

    @GetMapping("/testTransactional3")
    public String test3() {
        bookService.testTranscational3();
        return "SUCCESS";
    }

    @GetMapping("/testTransactional4")
    public String test4() {
        bookService.testTranscational4();
        return "SUCCESS";
    }
}
