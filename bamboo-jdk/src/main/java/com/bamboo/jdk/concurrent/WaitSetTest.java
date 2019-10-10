package com.bamboo.jdk.concurrent;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @Description
 * wait set
 * 如何理解WaitSet
 * 1. 所有对象均有一个 wait set， 用于存储调用该对象wait方法之后进入BLOCKED状态的线程
 * 2. 线程被notify之后，不一定立即被执行，原因是该对象的monitor暂时被调用该对象notify方法的线程持有
 * 3. 线程在wait set中被唤醒的顺序没有规律，不要误认为是按照FIFO
 * 4. 线程被唤醒后，如果继续执行需要重新获取对象的锁，同时被唤醒的线程会从wait断点继续执行
 * @Author victor su
 * @Date 2019/10/10 14:27
 **/
public class WaitSetTest {

    private static final Object LOCK = new Object();

    public static void main(String[] args) {

        /**
         * 测试被唤醒的线程被唤醒，继续执行代码
         */

        new Thread(() -> {
            work();
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (LOCK) {
            LOCK.notify();
        }

    }

    /**
     * 线程调用wait操作，进入 wait set
     */
    public static void testWaitSet() {
        IntStream.rangeClosed(1,10).forEach( i -> new Thread(String.valueOf(i)) {
                    @Override
                    public void run() {
                        synchronized (LOCK) {
                            Optional.of(Thread.currentThread().getName() + " will come to wait set.").ifPresent(System.out::println);
                            try {
                                LOCK.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Optional.of(Thread.currentThread().getName() + " will leave to wait set.").ifPresent(System.out::println);
                        }
                    }
                }.start()
        );

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        IntStream.rangeClosed(1,10).forEach( i -> {
            synchronized (LOCK) {
                LOCK.notify();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    /**
     * 模拟工作线程
     */
    public static void work () {
        synchronized (LOCK) {
            System.out.println("进入代码块...");

            try {
                System.out.println(Thread.currentThread().getName() + " 开始执行...");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait结束继续执行...");
        }
    }
}
