package com.bamboo.jdk.pattern.creation_builder;

import com.bamboo.jdk.pattern.creation_builder.builder_one.Builder;
import com.bamboo.jdk.pattern.creation_builder.builder_one.ConcreteBuilder;
import com.bamboo.jdk.pattern.creation_builder.builder_one.Director;
import com.bamboo.jdk.pattern.creation_builder.builder_one.Product;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/13 9:41
 **/
public class BuilderOneTest {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        System.out.println(product);
    }
}
