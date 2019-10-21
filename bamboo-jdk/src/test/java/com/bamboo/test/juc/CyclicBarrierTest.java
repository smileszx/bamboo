package com.bamboo.test.juc;

import com.bamboo.test.TestUtil;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/9 8:09
 **/
public class CyclicBarrierTest {


    @Test
    public void testCyclicBarrier() throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3, ()->{
            System.out.println("全体队友通过障碍物");
        });
        for(int i = 0; i < barrier.getParties(); i++){
            new Thread(new MyRunnable(barrier), "队友"+i).start();
        }

        Thread.currentThread().join(60_000);
        System.out.println("main function is finished.");

    }


    @Test
    public void testCyclicBarrierReset () {

        final CyclicBarrier barrier = new CyclicBarrier(3);

//        for(int i=0; i<3; i++) {
//            new Thread(()-> {
//                try {
//                    System.out.println(Thread.currentThread().getName() + ", 抵达循环屏障。");
//                    barrier.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//            }, "xbrain-" + i).start();
//        }
//
//        System.out.println("parties: " + barrier.getParties() + ", waiting: " + barrier.getNumberWaiting());

        for(int i=0; i<3; i++) {
            new Thread(()-> {
                try {
                    System.out.println(Thread.currentThread().getName() + ", 抵达循环屏障的线程。当前抵达屏障的线程数： " + barrier.getNumberWaiting());
                    barrier.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "compass-" + i).start();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.currentThread().join(60_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static class MyRunnable implements Runnable{
        private CyclicBarrier barrier;

        public MyRunnable(CyclicBarrier barrier){
            this.barrier = barrier;
        }

        @Override
        public void run() {
            for(int i = 0; i < 3; i++) {
                try {
                    Random rand = new Random();
                    int randomNum = rand.nextInt((3000 - 1000) + 1) + 1000;//产生1000到3000之间的随机整数
                    Thread.sleep(randomNum);
                    System.out.println(Thread.currentThread().getName() + ", 通过了第"+i+"个障碍物, 使用了 "+((double)randomNum/1000)+"s");
                    this.barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
