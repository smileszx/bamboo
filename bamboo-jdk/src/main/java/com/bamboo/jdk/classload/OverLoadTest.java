package com.bamboo.jdk.classload;

/**
 * @Description
 * 重载方法
 * @Author victor su
 * @Date 2019/10/27 21:45
 **/
public class OverLoadTest {
    public static void main(String[] args) {
        test(2, 2);
        test(1);
    }

    public static Integer test (Integer value, Integer key) {
        OverLoadTest overLoadTest;
        return value;
    }

    public static Integer test (Integer value) {
        return value;
    }

    /**
     * 关于方法重载请看官方文档：
     * https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html
     * 重载方法与返回参数无关，只与传入参数的类型和个数是否一致决定是否可以共存
     * Typically, a method has a unique name within its class. However,
     * a method might have the same name as other methods due to method overloading.
     *
     * The compiler does not consider return type when differentiating methods,
     * so you cannot declare two methods with the same signature even if they have a different return type.
    public static String test (Integer value) {
        return value.toString();
    }
     **/
}
