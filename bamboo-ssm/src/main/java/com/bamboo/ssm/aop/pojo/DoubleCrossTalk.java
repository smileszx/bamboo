package com.bamboo.ssm.aop.pojo;

import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/17 10:18
 **/
@Component
public class DoubleCrossTalk implements CrossTalk {
    @Override
    public void play() {
        System.out.println("相声讲究说学逗唱");
    }
}
