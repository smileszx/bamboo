package com.bamboo.ssm.temp;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/15 23:58
 **/
public class BambooBean implements Bamboo{

    @Override
    public void show(String msg) {
        System.out.println("I am a bamboo. " + msg);
    }

    @Override
    public String showName() {
        return "bamboo";
    }
}
