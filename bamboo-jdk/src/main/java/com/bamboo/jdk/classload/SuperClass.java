package com.bamboo.jdk.classload;

import javax.imageio.ImageReader;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * 模拟父类
 * @Author victor su
 * @Date 2019/10/15 10:37
 **/
public class SuperClass {

    /**
     * 类成员变量，也叫做静态变量
     * 设置成公开成员变量时，访问需要初始化当前类
     * 设置成私有成员变量，通过set和get方法赋值和访问均需初始化当前类
     */
    private static int value;

    /**
     * 类常量，private修饰时，需要通过静态的get方法访问，但是不能二次赋值，因此set方法无效
     * 定义时需要初始化赋值，编译器就完成初始化放在常量池中
     */
    private static final String key = "常量";

    /**
     * 类常量，定义时需要初始化赋值，编译器就完成初始化放在常量池中
     */
    public static final String share = "公开变量";

    /**
     * 注意类初始化时，类中的静态代码块只执行一次
     */
    static {
        System.out.println("SupperClass init!");
    }

    public void testA () {
        System.out.println("this is a normal method.");
    }

    public Number returnNumberClazz () {
        return new AtomicInteger();
    }

    public static void testB () {
        System.out.println("this is a static method.");
    }

    public static String getKey() {
        return key;
    }

    public static int getValue() {
        return value;
    }

    public static void setValue(int value) {
        SuperClass.value = value;
    }
}
