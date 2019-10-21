package com.bamboo.distribute.lock;

/**
 * @Description
 * 懒汉型单例模式，双重检测锁解决高并发模式下的线程安全问题
 * @Author victor su
 * @Date 2019/7/30 11:52
 **/
public class LazySingleton {
    // volatile修饰instance之后，之前的②和③之间的重排序将在多线程环境下被禁止，从而保证了线程安全执行。
    // 注意：这个解决方案需要JDK5或更高版本（因为从JDK5开始使用新的JSR-133内存模型规范，这个规范增强了volatile的语义）
    private static volatile LazySingleton instance = null;

    private LazySingleton(){
    }

    public static LazySingleton getInstance() {

        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    //memory = allocate() ;   //①分配对象的内存空间
                    //ctorInstance(memory);   //②初始化对象
                    //instance=memory;        //③设置instance指向刚分配的内存地址
                    //对象实例化过程为非线程安全，不具备原子性，②和③可能存在指令重排序问题
                    instance = new LazySingleton();
                }
            }
        }

        return instance;
    }

    //基于类初始化的解决方案
    //JVM在类的初始化阶段（即在Class被加载后，且被线程使用之前），会执行类的初始化。
    //在执行类的初始化期间，JVM会去获取一个锁。这个锁可以同步多个线程对同一个类的初始化。
    //基于这个特性，可以实现另一种线程安全的延迟初始化方案。
    private static class LazySingletonHolder {
        private static LazySingleton instance = new LazySingleton();
    }

    /**
     * 内部静态类实现单例类的延迟初始化
     * @return
     */
    public static LazySingleton getInstanceByHolder() {
        return LazySingletonHolder.instance;
    }


    public static void main(String[] args) {
        LazySingleton instance1 = getInstanceByHolder();
        LazySingleton instance2 = getInstanceByHolder();
        LazySingleton instance3 = getInstance();
        LazySingleton instance4 = getInstance();
        System.out.println(instance1);
        System.out.println(instance2);

        if(instance1.equals(instance2)) {
            System.out.println("双重检测锁，延迟加载单例模式");
        }

        if(instance3.equals(instance4)) {
            System.out.println("内部静态类，延迟加载单例模式");
        }
    }
}
