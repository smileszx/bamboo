package com.bamboo.ssm.aop.advice;

import com.bamboo.ssm.aop.pojo.DefaultEncoreable;
import com.bamboo.ssm.aop.pojo.Encoreable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/17 9:30
 **/
@Aspect
public class EncoreableInroducer {

    @DeclareParents(value = "com.bamboo.ssm.aop.pojo.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
