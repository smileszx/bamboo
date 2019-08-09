package com.bamboo.jdk;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/9 11:47
 **/
public class CommonUtil {

    public static void sleep(long mils){
        try {
            Thread.sleep(mils);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
