package com.bamboo.jdk.classload;

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
}
