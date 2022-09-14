package com.ruirui.mock.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @Author: 姚飞虎
 * @Date: 2021/9/22 11:06 上午
 * @Description:
 */
@Data
public class Book {
    private String title;
    private String author;
    private Double price;
    private LocalDate releaseTime;
}
