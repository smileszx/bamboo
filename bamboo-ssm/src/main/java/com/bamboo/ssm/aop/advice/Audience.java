package com.bamboo.ssm.aop.advice;

import org.aspectj.lang.annotation.*;

/**
 * @Description
 * 定义切面，观众类
 * @Author victor su
 * @Date 2019/7/17 7:52
 **/
//注解当前类不仅是POJO，而且还是一个切面
//@Aspect
public class Audience {
    //相同的切点表达式可以合并到一起，定义一个切点
    @Pointcut("execution(* com.bamboo.ssm.aop.pojo.Performance.perform(..))")
    public void performace() {}

    @Before("performace()")
    public void silenceCellPhones () {
        System.out.println("Silence cell phones.");
    }

    @Before("execution(* com.bamboo.ssm.aop.pojo.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("Taking seats.");
    }

    @AfterReturning("performace()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("performace()")
    public void demandRefund(){
        System.out.println("Demanding a refund.");
    }
}
