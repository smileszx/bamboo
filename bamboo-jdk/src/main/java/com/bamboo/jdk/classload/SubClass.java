package com.bamboo.jdk.classload;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description
 * 模拟子类
 * @Author victor su
 * @Date 2019/10/15 10:43
 **/
public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }

    public static int subint;

    @Override
    /**
     * 覆写父类方法，返回值类型可以协变
     * This technique, called covariant return type,
     * means that the return type is allowed to vary in the same direction as the subclass.
     */
    public AtomicLong returnNumberClazz() {
        return new AtomicLong();
    }
}
