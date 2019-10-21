package com.bamboo.test;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/9 10:58
 **/
public class TestUtil {


    public static void Sleep(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
