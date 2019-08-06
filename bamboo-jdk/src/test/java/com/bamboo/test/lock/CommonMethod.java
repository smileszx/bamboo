package com.bamboo.test.lock;

/**
 * @Description
 *
 * 1、对于静态方法，由于此时对象还未生成，所以只能采用类锁 *.class；
 *
 * 2、只要采用类锁，就会拦截所有线程，只能让一个线程访问。
 *
 * 3、对于对象锁（this），如果是同一个实例，就会按顺序访问，但是如果是不同实例，就可以同时访问。
 *
 * 4、如果对象锁跟访问的对象没有关系，那么就会都同时访问?
 *
 *
 *
 * @Author victor su
 * @Date 2019/8/6 23:41
 **/
public class CommonMethod {

    private static Object object = new Object();

    private static Object objA = new Object();

    private static Object objB = new Object();


    /**
     * synchronized修饰非静态方法， 默认对象锁（this）
     */
    public synchronized void testA(){

        System.out.println(Thread.currentThread().getName() + " 已经获取方法A的锁， 正在处理任务。。。");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    /**
     * synchronized修饰非静态方法， 默认对象锁（this）
     */
    public synchronized void testB(){

        System.out.println(Thread.currentThread().getName() + " 已经获取方法B的锁， 正在处理任务。。。");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 代码块加对象锁（this）
     *
     */
    public void testC() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " 已经获取方法C同步代码块的锁， 正在处理任务。。。");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 代码块加对象锁（object）
     */
    public void testD() {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + " 已经获取方法D同步代码块的锁， 正在处理任务。。。");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 代码块加类锁
     */
    public void testE() {
        synchronized (CommonMethod.class) {
            System.out.println(Thread.currentThread().getName() + " 已经获取方法D同步代码块的锁， 正在处理任务。。。");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void testF() {
        synchronized (objA) {
            System.out.println(Thread.currentThread().getName() + " 获取到objA锁，执行任务。。。");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objB){
                System.out.println(Thread.currentThread().getName() + " 获取到objB锁，执行任务。。。");
            }
        }
    }

    public void testG() {
        synchronized (objB) {
            System.out.println(Thread.currentThread().getName() + " 获取到objB锁，执行任务。。。");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objA) {
                System.out.println(Thread.currentThread().getName() + " 获取到objA锁，执行任务。。。");
            }
        }
    }

}
