package com.bamboo.ssm.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/17 8:22
 **/
//@Aspect
public class AudienceAround {
    //相同的切点表达式可以合并到一起，定义一个切点
    @Pointcut("execution(* com.bamboo.ssm.aop.pojo.Performance.perform(..))")
    public void performace() {}

    @Around("performace()")
    public void watchPerformance(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("Silence cell phones.");
            System.out.println("Taking seats.");
            joinPoint.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund.");
        }
    }
}
