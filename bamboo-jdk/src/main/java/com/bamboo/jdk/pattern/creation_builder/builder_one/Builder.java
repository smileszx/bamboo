package com.bamboo.jdk.pattern.creation_builder.builder_one;

/**
 * @Description
 * 创建类
 * @Author victor su
 * @Date 2019/8/13 9:29
 **/
public abstract class Builder {

    /**
     * 新建产品实例，空对象
     */
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    /**
     * 获取产品对象
     * @return
     */
    public Product getResult(){
        return product;
    }

}
