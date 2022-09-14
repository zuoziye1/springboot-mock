package com.ruirui.mock.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: 姚飞虎
 * @Date: 2022/5/13 11:47 PM
 * @Description:
 */
@Order(80)
@RestControllerAdvice
public class BusinessAExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleBusinessA(Exception e){
        return "handleBusinessA";
    }
}
