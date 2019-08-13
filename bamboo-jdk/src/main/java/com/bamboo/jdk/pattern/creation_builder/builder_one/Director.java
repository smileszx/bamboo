package com.bamboo.jdk.pattern.creation_builder.builder_one;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/13 9:37
 **/
public class Director {

    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public Product construct () {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
