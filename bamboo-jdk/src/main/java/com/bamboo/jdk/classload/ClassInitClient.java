package com.bamboo.jdk.classload;

/**
 * @Description
 * 测试类初始化相关场景
 * @Author victor su
 * @Date 2019/10/15 10:46
 **/
public class ClassInitClient {

    public static void main(String[] args) {
        // 调用类中定义的常量，不会初始化常量所在的类
        System.out.println(SuperClass.share);
        // 调用类的静态方法获取常量值，此时需要初始化常量所在类
        System.out.println(SuperClass.getKey());

        // 调用类中成员变量
        System.out.println(SuperClass.getValue());

        // 创建动作由newarray触发，不会初始化SubClass
        SubClass[] subArr = new SubClass[10];
    }
}
