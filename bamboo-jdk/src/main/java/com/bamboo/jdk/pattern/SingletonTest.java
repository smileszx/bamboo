package com.bamboo.jdk.pattern;

public class SingletonTest
{
    private SingletonTest(){}
    
    static class MyThread extends Thread {
        @Override
        public void run()
        {
            super.run();
            System.out.println("Thread running_"+Singleton.getInstance());
        }
    }

    //内部类SingletonHandler只有在getInstance()方法第一次调用的时候才会被加载（实现了延迟加载效果），
    // 而且其加载过程是线程安全的（实现线程安全）。内部类加载的时候只实例化了一次instance
    public static void main(String[] args)
    {
        MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();
        MyThread th3 = new MyThread();
        /*@1*/
        th1.start();
        th2.start();
        th3.start();

        
        /*@2
        Singleton.display();
        */
    }
}