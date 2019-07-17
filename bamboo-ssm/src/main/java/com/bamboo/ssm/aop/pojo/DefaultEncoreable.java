package com.bamboo.ssm.aop.pojo;

import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/17 9:34
 **/
@Component
public class DefaultEncoreable implements Encoreable {
    @Override
    public void performEncore() {
        System.out.println("郭老师，于老师，返个场！！！");
    }
}
