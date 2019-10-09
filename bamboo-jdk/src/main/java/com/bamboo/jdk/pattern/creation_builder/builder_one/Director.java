package com.bamboo.jdk.pattern.creation_builder.builder_one;

/**
 * @Description
 *
 * @Author victor su
 * @Date 2019/8/13 9:37
 **/
public class Director {

    private Builder builder;

    /**
     * 传入创建者
     * @param builder
     */
    public Director(Builder builder){
        this.builder = builder;
    }

    /**
     * 创建对象方法
     * @return
     */
    public Product construct () {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
