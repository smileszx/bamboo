package com.bamboo.distribute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication

@EnableEurekaServer
public class BambooDistributeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BambooDistributeApplication.class, args);
    }

}
