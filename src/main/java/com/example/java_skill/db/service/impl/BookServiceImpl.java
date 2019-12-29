package com.example.java_skill.db.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.java_skill.db.entity.Book;
import com.example.java_skill.db.entity.User;
import com.example.java_skill.db.mapper.BookMapper;
import com.example.java_skill.db.mapper.UserMapper;
import com.example.java_skill.db.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fuqiang
 * @version BookServiceImpl, v0.1 2019/12/29 7:06 下午
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public Book getById(Integer id) {
        return bookMapper.getById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean testTranscational() {
        Book book = new Book();
        book.setAuthor("小明");
        book.setName("啦啦啦");
        book.setPrice((double) 19);
        bookMapper.insert(book);
        List<Book> books = bookMapper.selectAll();
        System.out.println(JSONObject.toJSONString(books));//会打印刚刚插入的
        int i = 1/0;
        User user = new User();
        user.setName("小红");
        user.setAge(21);
        userMapper.insert(user);
        return true;
    }

    /**
     * 没加@Transactional，调用的方法加了，第一个插入成功，调用方法的第一个inert也插入成功
     */
    @Override
    public void testTranscational2() {
        Book book = new Book();
        book.setAuthor("小明");
        book.setName("啦啦啦");
        book.setPrice((double) 19);
        bookMapper.insert(book);
        List<Book> books = bookMapper.selectAll();
        System.out.println(JSONObject.toJSONString(books));//会打印刚刚插入的
        testTranscational();
    }

    /**
     * 加了@Transactional，调用的方法加了，都失败
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testTranscational3() {
        Book book = new Book();
        book.setAuthor("小明");
        book.setName("啦啦啦");
        book.setPrice((double) 19);
        bookMapper.insert(book);
        List<Book> books = bookMapper.selectAll();
        System.out.println(JSONObject.toJSONString(books));//会打印刚刚插入的
        testTranscational();
    }

    /**
     * 加了@Transactional，调用的方法没加，都失败
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testTranscational4() {
        Book book = new Book();
        book.setAuthor("小明");
        book.setName("啦啦啦");
        book.setPrice((double) 19);
        bookMapper.insert(book);
        List<Book> books = bookMapper.selectAll();
        System.out.println(JSONObject.toJSONString(books));//会打印刚刚插入的
        testTranscational5();
    }
    private boolean testTranscational5() {
        Book book = new Book();
        book.setAuthor("小明");
        book.setName("啦啦啦");
        book.setPrice((double) 19);
        bookMapper.insert(book);
        List<Book> books = bookMapper.selectAll();
        System.out.println(JSONObject.toJSONString(books));//会打印刚刚插入的
        int i = 1/0;
        User user = new User();
        user.setName("小红");
        user.setAge(21);
        userMapper.insert(user);
        return true;
    }
}
