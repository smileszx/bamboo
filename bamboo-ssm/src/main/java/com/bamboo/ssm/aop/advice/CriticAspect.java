package com.bamboo.ssm.aop.advice;

import com.bamboo.ssm.aop.pojo.CriticismEngine;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/17 10:51
 **/
@Aspect
public class CriticAspect {

    public CriticAspect(){}
    @Pointcut("execution(* com.bamboo.ssm.aop.pojo.Performance.perform(..))")
    public void performance(){}


    @AfterReturning("performance()")
    public void critic(){
        System.out.println(criticismEngine.getCriticism());
    }

    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
