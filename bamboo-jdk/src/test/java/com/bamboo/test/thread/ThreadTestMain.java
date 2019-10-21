package com.bamboo.test.thread;

import com.bamboo.test.TestUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/8 8:49
 **/
public class ThreadTestMain {
    private static final CyclicBarrier barrier = new CyclicBarrier(3);
    public static void main(String[] args) {

        for(int i=0; i<3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + ", 抵达循环屏障的线程。当前抵达屏障的线程数： " + barrier.getNumberWaiting());
                        barrier.await();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            } , "compass-" + i).start();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
