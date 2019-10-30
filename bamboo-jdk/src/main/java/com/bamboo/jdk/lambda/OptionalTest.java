package com.bamboo.jdk.lambda;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @Description
 * Optional类测试
 * @Author victor su
 * @Date 2019/10/30 22:01
 **/
public class OptionalTest {


    public static void main(String[] args) {
        Optional<String> optional = Optional.of("a");
        System.out.println(optional.get());

        Optional<Integer> op = Optional.empty();
        System.out.println(op.equals(Optional.ofNullable(null)));
        System.out.println(op.orElseGet(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 666;
            }
        }));
    }
}
