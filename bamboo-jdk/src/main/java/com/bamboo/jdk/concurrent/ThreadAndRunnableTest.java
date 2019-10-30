package com.bamboo.jdk.concurrent;

/**
 * @Description
 * Thread和Runnable到底什么区别？
 * @Author victor su
 * @Date 2019/10/30 14:46
 **/
public class ThreadAndRunnableTest {

    public static void main(String[] args) {
        RunnableTask task = new RunnableTask();
        // main 线程执行
//        task.run();
        Thread thread = new Thread(new RunnableTask(), "自定义线程");
        //单个线程异常可以使用异常处理器，可以捕获后处理
        thread.setUncaughtExceptionHandler(
                new RewriteUncatchtExceptionHandler()

        );
        // 自定义线程执行
        thread.start();
    }
}
