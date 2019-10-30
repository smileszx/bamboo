package com.bamboo.jdk.concurrent;

import java.util.concurrent.*;

/**
 * @Description
 * 带返回值的任务测试
 * @Author victor su
 * @Date 2019/10/30 18:59
 **/
public class CallableThreadExceptionTest {

    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new CallableTask());

        Future<String> future = (Future<String>) pool.submit(new CallableTask());
        try {
            long start = System.currentTimeMillis();
            String result = future.get();
            System.out.println(Thread.currentThread().getName() + " " + result + ", cost: " + (System.currentTimeMillis()-start) +         "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
