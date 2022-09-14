package com.ruirui.mock.service;

import com.ruirui.mock.entity.Book;

/**
 * @Author: 姚飞虎
 * @Date: 2021/9/22 11:08 上午
 * @Description:
 */
public interface BookService {

    Book queryByTitle(String title);
}
