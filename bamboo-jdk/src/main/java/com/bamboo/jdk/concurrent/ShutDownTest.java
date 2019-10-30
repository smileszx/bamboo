package com.bamboo.jdk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * 线程池shutdown测试
 * @Author victor su
 * @Date 2019/10/30 18:12
 **/
public class ShutDownTest {

    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            pool.submit(new CustomTask());
        }
        // 关闭线程池，已经submit的任务继续执行完成
        pool.shutdown();

        // 关闭线程池，尝试打断已经submit的任务
//        pool.shutdownNow();

        // 关闭线程池后无法再向线程池中添加任务
        pool.submit(new CustomTask());
    }

}
