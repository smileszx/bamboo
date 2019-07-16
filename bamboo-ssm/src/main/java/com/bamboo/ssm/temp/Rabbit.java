package com.bamboo.ssm.temp;

import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/16 12:27
 **/
@Component
@com.bamboo.ssm.annotation.Rabbit
public class Rabbit implements Animal {
    @Override
    public void introduce() {
        System.out.println("I am a rabbit.");
    }
}
