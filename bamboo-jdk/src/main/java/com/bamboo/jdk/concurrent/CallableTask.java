package com.bamboo.jdk.concurrent;

import java.util.concurrent.Callable;

/**
 * @Description
 * 带返回值的任务
 * @Author victor su
 * @Date 2019/10/30 18:54
 **/
public class CallableTask implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(2000);
        return Thread.currentThread().getName() + "-返回值";
    }
}
