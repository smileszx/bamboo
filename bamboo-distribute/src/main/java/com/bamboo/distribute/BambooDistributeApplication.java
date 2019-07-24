package com.bamboo.distribute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//添加spring-cloud-starter-netflix-eureka-client，自动注册到Eureka Server，
// 不需要@EnableEurekaClient
//@EnableEurekaClient
public class BambooDistributeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BambooDistributeApplication.class, args);
    }

}
