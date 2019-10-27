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
     * 重载方法与返回参数无关，只与传入参数的类型和个数是否一致决定是否可以共存
    public static String test (Integer value) {
        return value.toString();
    }
     **/
}
