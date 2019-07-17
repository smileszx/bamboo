package com.bamboo.ssm.aop.pojo;

import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/17 8:14
 **/
@Component
public class SingPerformance implements Performance {
    @Override
    public void recordOrder(int order) {
        System.out.println("播放歌曲： " + order);
    }

    @Override
    public void perform() {
        System.out.println("天青色等烟雨，而我在等你...");
//        System.out.println(1/0);
    }
}
