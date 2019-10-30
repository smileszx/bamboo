package com.bamboo.jdk.concurrent;

import com.bamboo.jdk.error.NewException;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/10/30 14:44
 **/
public class RunnableTask implements Runnable, SomeService{
    @Override
    public void run() {
        sayHello();
        int i = 1/0;
    }

    @Override
    public void sayHello() {
        System.out.println(Thread.currentThread().getName() + ", hello world!");
    }
}
