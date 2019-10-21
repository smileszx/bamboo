package com.bamboo.jdk.synclock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * @Description
 * 同步块和同步方法synchronized关键字实现细节
 *
 * 同步原语 monitor
 * 实际上，monitor 是属于编程语言的范畴，当你想要使用 monitor 时，先了解一下语言本身是否支持 monitor 原语，
 * 例如 C 语言它就不支持 monitor，Java 语言支持 monitor。
 * monitor 的重要特点是，同一个时刻，只有一个 进程/线程 能进入 monitor 中定义的临界区，这使得 monitor 能够达到互斥的效果。
 * 但仅仅有互斥的作用是不够的，无法进入 monitor 临界区的 进程/线程，它们应该被阻塞，并且在必要的时候会被唤醒。
 *
 * monitor 机制需要几个元素来配合，分别是：
 * - 临界区
 * - monitor 对象及锁
 * - 条件变量以及定义在 monitor 对象上的 wait，signal 操作。
 *
 * @Author victor su
 * @Date 2019/10/10 11:51
 **/
public class SyncLockTest {
    private static Logger LOGGER = Logger.getLogger("synchronized关键字测试");

    private static ExecutorService pool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        /**
         * 对SyncLockTest的Class对象进行加锁
         */
        synchronized (SyncLockTest.class) {
            LOGGER.info(Thread.currentThread().getName() + ", 开始执行同步代码块");
        }
        /**
         * 静态同步方法，默认对SyncLockTest的Class对象进行加锁
         */
        play();


        /**
         * 单个线程的线程池
         */
        for(int i=0; i<10; i++) {
            pool.submit(new PlayTask());
        }

        pool.shutdown();

    }


    /**
     * 静态同步方法，默认对SyncLockTest的Class对象进行加锁
     * 线程必须先拿到对象的Monitor才能进入同步方法并执行
     */
    public static synchronized void play() {
        LOGGER.info(Thread.currentThread().getName() + ", 开始执行同步play方法");
    }

    /**
     * 内部静态类
     */
    static class PlayTask implements Runnable {

        @Override
        public void run() {
            LOGGER.info(Thread.currentThread().getName() + ", 开始执行同步play方法");
            long start = System.currentTimeMillis();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LOGGER.info(Thread.currentThread().getName() + ", 开始执行同步play方法, 耗时：" + (System.currentTimeMillis() -start) + "ms");

            play();
        }
    }
}
