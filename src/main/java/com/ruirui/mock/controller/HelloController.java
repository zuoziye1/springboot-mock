package com.ruirui.mock.controller;

import com.ruirui.mock.config.exception.BusinessAException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Author: 姚飞虎
 * @Date: 2022/5/13 11:47 PM
 * @Description:
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        Random random=new Random();
        int a=random.nextInt(25);
        System.out.println(a);
        if(a < 20){
            throw new BusinessAException("business");
        }
        return "hello";
    }
}
