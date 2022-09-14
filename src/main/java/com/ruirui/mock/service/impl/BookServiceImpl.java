package com.ruirui.mock.service.impl;

import com.ruirui.mock.entity.Book;
import com.ruirui.mock.service.BookService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @Author: 姚飞虎
 * @Date: 2021/9/22 11:09 上午
 * @Description:
 */
@Service
public class BookServiceImpl implements BookService {

    @Override
    public Book queryByTitle(String title) {
        Book book = new Book();
        book.setAuthor("dax");
        book.setPrice(78.56);
        book.setReleaseTime(LocalDate.of(2018, 3, 22));
        book.setTitle(title);
        return book;
    }
}
