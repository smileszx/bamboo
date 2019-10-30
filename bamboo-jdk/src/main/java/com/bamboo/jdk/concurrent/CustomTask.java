package com.bamboo.jdk.concurrent;

/**
 * @Description
 * 自定义任务
 * @Author victor su
 * @Date 2019/10/30 18:13
 **/
public class CustomTask implements Runnable{
    private static long index = 0;
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + ", index: " + (++index));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
