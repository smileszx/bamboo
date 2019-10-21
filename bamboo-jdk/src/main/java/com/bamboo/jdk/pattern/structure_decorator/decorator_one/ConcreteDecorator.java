package com.bamboo.jdk.pattern.structure_decorator.decorator_one;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/13 22:28
 **/
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void operation(){
        super.operation();
        addedBehavior();
    }

    public void addedBehavior() {
        System.out.println("add behavior.");
    }
}
