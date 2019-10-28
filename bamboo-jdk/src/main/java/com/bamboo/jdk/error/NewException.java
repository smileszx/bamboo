package com.bamboo.jdk.error;

/**
 * @Description
 * 自定义一个异常
 * @Author victor su
 * @Date 2019/10/28 17:04
 **/
public class NewException extends Exception {

    public NewException() {
    }

    public NewException(String message) {
        super(message);
    }
}
