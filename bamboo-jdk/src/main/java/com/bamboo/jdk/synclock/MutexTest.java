package com.bamboo.jdk.synclock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/**
 * @Description
 * AQS源码Demo测试
 * @Author victor su
 * @Date 2019/10/16 22:16
 **/
public class MutexTest {

    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Mutex mutex = new Mutex();
        Condition condition = mutex.newCondition();
        for(int i=0; i<10; i++) {
            pool.submit(() -> {
                mutex.lock();
                System.out.println(Thread.currentThread().getName() + mutex.isLocked());
                mutex.unlock();
            });
        }

        System.out.println(mutex.hasQueuedThreads());
        pool.shutdown();
    }
}
