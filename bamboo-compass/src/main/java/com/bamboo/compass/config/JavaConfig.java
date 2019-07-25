package com.bamboo.compass.config;

import com.bamboo.compass.consumer.irule.CustomRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/24 21:46
 **/
@Configuration
public class JavaConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }

//    @Bean
//    public IRule loadBalanceRule() {
//        List<Integer> ports = new ArrayList<>();
//        ports.add(8082);
//        return new CustomRule(ports);
//    }

    @Bean
    public IRule loadBalanceRule() {
        return new RoundRobinRule();
    }
}
