package com.bamboo.test.thread;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/8 8:49
 **/
public class ThreadTestMain {

    public static void main(String[] args) {
        Thread threadA = new Thread(()->{
            System.out.println("run......");
        }, "线程A-");
        System.out.println(threadA.getName() + threadA.getState());

        threadA.start();
        System.out.println(threadA.getName() +threadA.getState());

        synchronized (threadA){
            try {
                threadA.join(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadA.getName() +threadA.getState());
        }
    }
}
