package com.bamboo.jdk.pattern.creation_builder.builder_one;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/13 9:33
 **/
public class ConcreteBuilder extends Builder {
    @Override
    public void buildPartA() {
        super.product.setPartA("轮胎");
    }

    @Override
    public void buildPartB() {
        super.product.setPartB("底盘");
    }

    @Override
    public void buildPartC() {
        super.product.setPartC("发动机");
    }
}
