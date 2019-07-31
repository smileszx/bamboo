package com.bamboo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//开启Zuul代理模式
@EnableZuulProxy
@SpringBootApplication
public class BambooZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(BambooZuulApplication.class, args);
    }

}
