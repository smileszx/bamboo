package com.bamboo.jdk.lambda;

/**
 * 自定义函数式接口
 * 该接口只有一个抽象方法
 *
 */

@FunctionalInterface
public interface GreetingService {

    /**
     * 唯一的抽象方法
     * 接口中的方法默认用public abstract修饰，如下所示
     * @param message
     */
    public abstract void sendMessage(String message);


    /**
     * 函数式接口可以包含默认方法，因为默认方法不是抽象方法，
     * 默认方法有一个默认实现，因此符合函数式接口定义。
     */
    default void defaultMethod(){
        System.out.println("I am a default Method");
    }

    /**
     * 函数式接口可以包含静态方法，因为静态方法不是抽象方法，
     * 是一个已经实现了的方法，因此符合函数式接口定义。
     */
    static void staticMethod(){
        System.out.println("I am a static method");
    }

    /**
     * 函数式接口可以包含Object里面的public方法，这些方法对于函数式接口来讲，
     * 不被看作抽象方法，因为任何一个函数式接口的实现，都默认继承了Object类，
     * 包含了Object类中对这些抽象方法的实现。
     * @param obj
     * @return
     */
    @Override
    boolean equals(Object obj);
}
