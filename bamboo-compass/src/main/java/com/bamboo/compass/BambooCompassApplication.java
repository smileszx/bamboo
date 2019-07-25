package com.bamboo.compass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description TODO
 * @Author Thinkpad
 * @Date 2019/7/4 8:25
 **/
//@SpringBootApplication
//指定Feign接口所在包
@EnableFeignClients(basePackages = "com.bamboo.compass.consumer.service")
//添加spring-cloud-starter-netflix-eureka-client，自动注册到Eureka Server，
// 不需要@EnableEurekaClient
//@EnableEurekaClient
@SpringCloudApplication
//开启Hystrix仪表盘功能
@EnableHystrixDashboard
public class BambooCompassApplication{

    public static void main(String[] args) {
        SpringApplication.run(BambooCompassApplication.class, args);
    }
}
