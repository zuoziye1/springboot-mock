package com.ruirui.mock.api;

import com.ruirui.mock.entity.Book;
import com.ruirui.mock.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: 姚飞虎
 * @Date: 2021/9/22 11:05 上午
 * @Description:
 */
@RestController
@RequestMapping("/book")
public class BookApi {
    @Resource
    private BookService bookService;

    @GetMapping("/get")
    public Book getBook(String title) {
        return bookService.queryByTitle(title);
    }

}
