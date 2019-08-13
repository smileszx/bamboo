package com.bamboo.jdk.pattern.structure_decorator.decorator_one;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/13 22:34
 **/
public class ComponentImplA implements Component {
    @Override
    public void operation() {
        System.out.println("我是被装饰类的实现类，实现其抽象方法。");
    }

}
