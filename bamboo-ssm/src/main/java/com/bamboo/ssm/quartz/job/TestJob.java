package com.bamboo.ssm.quartz.job;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/28 9:06
 **/
public class TestJob {

    public void execute() {
        System.out.println("Quartz 定时任务测试..." + System.currentTimeMillis());
    }
}
