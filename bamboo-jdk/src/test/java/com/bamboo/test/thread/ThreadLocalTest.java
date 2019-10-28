package com.bamboo.test.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/7 17:05
 **/
public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static ExecutorService pool = Executors.newFixedThreadPool(5);

    @Test
    public void testThreadLocal () {

        threadLocal.set(Thread.currentThread().getName() + ", init thread local value");

        System.out.println(threadLocal.get());

        pool.execute(()->{
            threadLocal.set(Thread.currentThread().getName() + ", init thread local value");
        });
        pool.execute(()->{
            threadLocal.set(Thread.currentThread().getName() + ", init thread local value");
        });
        pool.execute(()->{
            threadLocal.set(Thread.currentThread().getName() + ", init thread local value");
        });
        pool.execute(()->{
            threadLocal.set(Thread.currentThread().getName() + ", init thread local value");
        });
        pool.execute(()->{
            threadLocal.set(Thread.currentThread().getName() + ", init thread local value");
        });



    }


    @Test
    public void testThreadCommon() throws InterruptedException {

        //对象锁
        final Object object = new Object();

        Thread threadA = new Thread(()->{
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "获取到object锁");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("wake......");
                System.out.println(Thread.currentThread().getName() + Thread.currentThread().getState());
            }
        }, "线程A-");
        System.out.println(threadA.getName() + threadA.getState());
        threadA.start();
        Thread.sleep(100);
        System.out.println(threadA.getName() + threadA.getState());

        Thread threadB = new Thread(()->{
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "获取到object锁");
                object.notify();

//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + Thread.currentThread().getState());
            }
        }, "线程B-");
        System.out.println(threadB.getName() + threadB.getState());
        threadB.start();
        Thread.sleep(100);
        System.out.println(threadB.getName() + threadB.getState());


//        Thread.currentThread().join();
    }


    @Test
    public void testThreadJoin () throws InterruptedException {
        Thread thread1= new Thread(new Runnable() {
            @Override
            public void run() {
                IntStream.range(1, 100).forEach(i -> System.out.println(Thread.currentThread().getName() + "> " + i));
            }
        }, "线程A-");

        Thread thread2= new Thread(new Runnable() {
            @Override
            public void run() {
                IntStream.range(1, 100).forEach(i -> System.out.println(Thread.currentThread().getName() + "> " + i));
            }
        }, "线程B-");

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(Thread.currentThread().getName() + " print finish.");



    }
}
