package com.bamboo.jdk.error;

/**
 * @Description
 * 测试自定义异常
 * @Author victor su
 * @Date 2019/10/28 17:06
 **/
public class ExceptionTest {


    public static void main(String[] args) {
        int m = 1;

        if (m < 2) {
            try {
                throw new NewException("测试自定义异常");
            } catch (NewException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
