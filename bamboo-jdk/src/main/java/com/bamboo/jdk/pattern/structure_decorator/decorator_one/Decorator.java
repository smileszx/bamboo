package com.bamboo.jdk.pattern.structure_decorator.decorator_one;


/**
 * @Description
 * 装饰器(Decorator),对原有对象进行装饰，通过装饰来扩展原有对象的功能。
 * @Author victor su
 * @Date 2019/8/13 21:46
 **/
public abstract class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operation () {
        component.operation();
    }
}
