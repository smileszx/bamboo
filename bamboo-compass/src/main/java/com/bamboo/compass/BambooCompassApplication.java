package com.bamboo.compass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author Thinkpad
 * @Date 2019/7/4 8:25
 **/
@SpringBootApplication
//添加spring-cloud-starter-netflix-eureka-client，自动注册到Eureka Server，
// 不需要@EnableEurekaClient
//@EnableEurekaClient
public class BambooCompassApplication{

    public static void main(String[] args) {
        SpringApplication.run(BambooCompassApplication.class, args);
    }
}
