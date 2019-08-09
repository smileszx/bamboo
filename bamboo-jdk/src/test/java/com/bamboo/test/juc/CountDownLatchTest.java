package com.bamboo.test.juc;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/6 17:33
 **/
public class CountDownLatchTest {

    private static ExecutorService pool = Executors.newCachedThreadPool();


    @Test
    public void testCountDownLatch() {

        CountDownLatch latch = new CountDownLatch(3);
        Random timecost = new Random(1);

        long start = System.currentTimeMillis();
        pool.execute(()->{
            long now = System.currentTimeMillis();
            Sleep(timecost.nextInt(5));
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + ", count: " +  latch.getCount() + ", cost: " + (System.currentTimeMillis() - now) + "ms");
        });

        pool.execute(()->{
            long now = System.currentTimeMillis();

            Sleep(timecost.nextInt(5));
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + ", count: " + latch.getCount()+ ", cost: " + (System.currentTimeMillis() - now) + "ms");
        });

        pool.execute(()->{
            long now = System.currentTimeMillis();

            Sleep(timecost.nextInt(5));
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + ", count: " + latch.getCount()+ ", cost: " + (System.currentTimeMillis() - now) + "ms");
        });
        try {
            latch.await();
            System.out.println("任务耗时：" + (System.currentTimeMillis() - start) + "ms, 开始汇总计算");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pool.shutdown();
    }



    private void Sleep(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
