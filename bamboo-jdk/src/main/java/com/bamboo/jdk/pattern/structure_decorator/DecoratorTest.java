package com.bamboo.jdk.pattern.structure_decorator;

import com.bamboo.jdk.pattern.structure_decorator.decorator_one.ComponentImplA;
import com.bamboo.jdk.pattern.structure_decorator.decorator_one.ConcreteDecorator;
import com.bamboo.jdk.pattern.structure_decorator.decorator_one.Decorator;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/13 22:35
 **/
public class DecoratorTest {

    public static void main(String[] args) {
//        Decorator decorator = new ConcreteDecorator(new ComponentImplA());
//
//        decorator.operation();
//        ((ConcreteDecorator) decorator).addedBehavior();


        Set<Integer> s = new InstrumentedSet<>(new HashSet<>(10));
        s.add(1);
        s.add(2);
        s.add(1);


        int result = ((InstrumentedSet<Integer>) s).getAddCount();

        System.out.println(result);

    }
}
