package com.bamboo.brain.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * DemoController测试
 * @Author victor su
 * @Date 2019/10/27 10:56
 **/
@RestController
@RequestMapping("/brain")
public class DemoController {
    @RequestMapping(value = "/welcome/{id}")
    public String hello (@PathVariable("id") Integer id) {
        System.out.println("hello " + id);
        return "hello " + id;
    }

    @RequestMapping(value = "/test/{id}")
    public String helloObj (@PathVariable("id") Integer id) {
        int[] arr = new int[10];
        System.out.println("hello " + id + arr.toString());
        return "hello " + id + arr.toString();
    }
}
