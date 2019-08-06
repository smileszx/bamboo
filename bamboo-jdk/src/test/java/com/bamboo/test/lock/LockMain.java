package com.bamboo.test.lock;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/6 23:57
 **/
public class LockMain {
    private static ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

        CommonMethod commonMethod = new CommonMethod();


        pool.execute(() ->{
            commonMethod.testF();
        });


//        pool.execute(() ->{
//            commonMethod.testG();
//        });

        pool.shutdown();
    }
}
