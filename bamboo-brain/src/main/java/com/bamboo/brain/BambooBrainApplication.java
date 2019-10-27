package com.bamboo.brain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description
 *
 * @Author victor su
 * @Date 2019/10/27 10:53
 **/
@SpringBootApplication
@EnableEurekaClient
@ImportResource(locations = "spring-elastic-job.xml")
public class BambooBrainApplication {
    public static void main(String[] args) {
        SpringApplication.run(BambooBrainApplication.class, args);
    }
}
