package com.bamboo.jdk.lambda;

import org.apache.commons.lang3.time.FastDateFormat;

import javax.swing.text.DateFormatter;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @Description
 *
 * Lambda表达式是静态类型的
 *
 * @Author victor su
 * @Date 2019/8/16 21:49
 **/
public class LambdaExpression{
    //Java 8 为该类新加了一个工厂方法， 接受一个 Lambda 表达式， 并产生
    //一个新的 ThreadLocal 对象， 而不用使用继承， 语法上更加简洁。
    public final static ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));


    public static void main(String[] args) {

        FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd");

        System.out.println(format.format(new Date()));

    }


    /**
     *
     * Lambda 表达式中的类型推断， 实际上是 Java 7 就引入的目标类型推断的扩展
     * Java 7 中的菱形操作符， 它可使 javac 推断出泛型参数的类型。
     */
    public static void testLambdaParamType () {

        //Java7菱形操作符<>,可以使javac推断出泛型参数

        //明确指定泛型的类型
        Map<String, Integer> oldWordCounts = new HashMap<String, Integer>();
        //菱形操作符
        Map<String, Integer> diamondWordCounts = new HashMap<>();

        //Java7 无法推测出参数
        LambdaCommon.useHashMap(new HashMap<>());


    }

    /**
     * 函数接口是只有一个抽象方法的接口， 用作 Lambda 表达式的类型。
     */
    public static void testLamdaFunctionalInterface () {
        //Predicate 接口的源码， 接受一个对象， 返回一个布尔值
        Predicate<Integer> atLeast5 = x -> x > 5;
        System.out.println(atLeast5.test(6));
        System.out.println(atLeast5.test(3));

        //BinaryOperator
        BinaryOperator<Long> addLongs = (x, y) -> x + y;
        System.out.println(addLongs.apply(1l, 2l));
    }

    /**
     * lambda表达式引用的是变量值而非引用
     */
    public static void testLambdaFinalParam () {
        //既成事实上的 final 变量， 显式或隐式，变量无法重新赋值，lambda表达式引用的是变量值而非引用
        String s = "runnable";
//        s = "dd";

        Runnable task = () -> {
            System.out.println(s);
            //Variable used in lambda expression should be final or effectively final.
//            s = "new runnable";
        };
        task.run();
    }

    /**
     * Lambda表达式举例
     */
    public static void testLambdaBase () {
        Runnable noArguments = () -> System.out.println("Hello World");
        noArguments.run();
        ActionListener oneArgument = event -> System.out.println("button cliked");

        Runnable multiStatement = () -> {
            System.out.println("Hello");
            System.out.println(" World");
        };
        multiStatement.run();
        BinaryOperator<Long> add = (x, y) -> x + y;
        long res = add.apply(1000l, 4000l);
        System.out.println("(x, y) -> x + y =>" + res);
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
        long resa =addExplicit.apply(1000l, 4000l);
        System.out.println("(Long x, Long y) -> x + y" + resa);
    }
}
