package com.bamboo.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description
 * 服务发现Eureka Server
 * Eureka与Zookeeper均可以充当服务中心，区别在于对CAP原则支持不同
 * Eureka支持AP原则
 * Zookeeper支持CP原则
 * @Author victor su
 * @Date 2019/7/24 20:45
 **/
@SpringBootApplication
// 开启Eureka服务
@EnableEurekaServer
public class EurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class, args);
    }
}
