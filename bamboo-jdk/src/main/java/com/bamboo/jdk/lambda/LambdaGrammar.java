package com.bamboo.jdk.lambda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * @Description
 * Lambda表达式识别
 * @Author victor su
 * @Date 2019/10/30 22:54
 **/
public class LambdaGrammar {

    public static void main(String[] args) {
        //1. Lambda表达式不包含参数，使用空括号() 表示无参数
        Thread thread = new Thread(() -> System.out.println(Thread.currentThread().getName() + ", 无参"));

        //2. Lambda表达式有且只有一个参数，可以省略参数的括号
//        ActionListener oneArgument = (ActionEvent event) -> System.out.println("button clicked");

        ActionListener oneArgument = event -> System.out.println("button clicked");


        //3. Lambda表达式主体不只包含一个表达式，也可以是一段代码，此时需要用大括号{}括起来。
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getContextClassLoader());
        };
        //4. Lambda表达式也可以表示多个参数的方法
        BinaryOperator<Long> addExplicit = (a, b) -> a + b;

        //5. Lambda表达式参数可以显示声明类型，此时需要用小括号括起来
        BinaryOperator<Long> addExplicitDeclareType = (Long a, Long b) -> a + b;

    }
}
