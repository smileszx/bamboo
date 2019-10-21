package com.bamboo.jdk.lambda;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/6 10:44
 **/
public class GreetingServiceMain {
    public static void main(String[] args) {
        GreetingService greetingService = message -> System.out.println("Hello " + message);

        greetingService.sendMessage("Bad boy!");
        greetingService.defaultMethod();

    }
}
