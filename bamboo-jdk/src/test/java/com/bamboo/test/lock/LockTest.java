package com.bamboo.test.lock;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/6 23:44
 **/
public class LockTest {

    private static Executor pool = Executors.newFixedThreadPool(5);


    @Test
    public void testMethodSyncLock () {
        CommonMethod commonMethod = new CommonMethod();
        pool.execute(() ->{
            commonMethod.testA();
        });

        pool.execute(() ->{
            commonMethod.testB();
        });
    }

    @Test
    public void testSyncCodeLock () {

        CommonMethod commonMethod = new CommonMethod();

        pool.execute(() ->{
            commonMethod.testC();
        });

        pool.execute(() ->{
            commonMethod.testC();
        });
    }
}
