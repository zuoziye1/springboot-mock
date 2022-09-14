package com.ruirui.mock.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Author: 姚飞虎
 * @Date: 2022/5/13 7:52 PM
 * @Description:
 */
@Order(10)
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleGlobal(Exception e){
        return "handleGlobal";
    }
}
