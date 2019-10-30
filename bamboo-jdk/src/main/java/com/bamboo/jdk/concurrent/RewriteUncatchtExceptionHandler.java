package com.bamboo.jdk.concurrent;

/**
 * @Description
 * 线程未捕获异常
 * @Author victor su
 * @Date 2019/10/30 16:07
 **/
public class RewriteUncatchtExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName() + " ========== " + e.toString());
//        e.printStackTrace();
    }
}
