package com.bamboo.jdk.pattern.creation_builder.builder_one;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/13 9:29
 **/
public abstract class Builder {

    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Product getResult(){
        return product;
    }

}
